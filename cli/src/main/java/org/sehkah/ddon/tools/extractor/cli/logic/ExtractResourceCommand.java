package org.sehkah.ddon.tools.extractor.cli.logic;

import lombok.extern.slf4j.Slf4j;
import org.sehkah.ddon.tools.extractor.api.entity.Resource;
import org.sehkah.ddon.tools.extractor.api.error.SerializerException;
import org.sehkah.ddon.tools.extractor.api.error.TechnicalException;
import org.sehkah.ddon.tools.extractor.api.io.BinaryReader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ClientResourceFileExtension;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ClientVersion;
import org.sehkah.ddon.tools.extractor.api.serialization.SerializationFormat;
import org.sehkah.ddon.tools.extractor.api.serialization.Serializer;
import org.sehkah.ddon.tools.extractor.common.logic.resource.ClientResourceFileManager;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.Archive;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.texture.DirectDrawSurface;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.texture.Texture;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.ClientResourceFileManagerSeason1;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.ClientResourceFileManagerSeason2;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.ClientResourceFileManagerSeason3;
import picocli.CommandLine;
import org.apache.commons.codec.digest.DigestUtils;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.function.Predicate;
import java.util.stream.Stream;

@Slf4j
@CommandLine.Command(name = "resource", mixinStandardHelpOptions = true, version = "resource 1.0",
        description = "Extracts the provided DDON resource file(s).")
public class ExtractResourceCommand implements Callable<Integer> {
    private ClientResourceFileManager clientResourceFileManager;

    @CommandLine.Option(names = {"-f", "--format"}, arity = "0..1", description = """
            Optionally specify the output format (${COMPLETION-CANDIDATES}).
            If omitted the default format is used (json).
            Example:
                 resource --format=JSON FILE  outputs the data with the JSON format on the console
                 resource --format FILE   outputs the data with the default format on the console"
            """, defaultValue = "json")
    private SerializationFormat outputFormat;

    @CommandLine.Parameters(index = "0", arity = "1", description = """
            Specifies the DDON client root folder.
            This will be used as a basis to derive further meta information for certain files where supported and enabled.
            See the meta information flag for further information.
            Example:
                resource "D:\\DDON" <resource file>
            """)
    private Path clientRootFolder;

    @CommandLine.Parameters(index = "1", arity = "1", description = """
            Specifies the DDON client translation file.
            This will be used to dump messages in both JP and EN.
            See the meta information flag for further information.
            Example:
                resource "D:\\DDON" "D:\\DDON-translation\\gmd.csv" <resource file>
            """)
    private Path clientTranslationFile;

    @CommandLine.Parameters(index = "2", arity = "1", description = """
            Specifies the DDON client resource file whose data to extract or a folder to recursively search for such files.
            The full path starting from the client resource base path must be specified, i.e. from "rom".
            Example:
                resource <client resource base path> "game_common\\param\\enemy_group.emg" will resource the data of the enemy_group.emg resource file.
                resource <client resource base path> "game_common\\param" will resource the data of all resource files found in this path.
            """)
    private Path inputFilePath;

    @CommandLine.Option(names = {"-o"}, arity = "0..1", description = """
            Optionally specify whether to output the extracted data as a file.
            If omitted the default behavior is to output to console.
            Example:
                resource -o FILE outputs the data in a file relative to the current working directory based on the input file name.
            """, defaultValue = "false")
    private boolean writeOutputToFile;

    @CommandLine.Option(names = {"-m", "--meta-information"}, arity = "0..1", description = """
            Optionally specify whether to enrich the output with additional meta information (if available).
            If omitted the default behavior is not to add meta information.
            
            For example, if a numeric type has a corresponding (probable) semantic mapping this will be output as additional field.
            Note that this makes the output more comprehensible at the price of serialization compatibility and accuracy.
            """, defaultValue = "false")
    private boolean addMetaInformation;

    @CommandLine.Option(names = {"-u", "--unpack-archives"}, arity = "0..1", description = """
            Optionally specify whether to unpack .arc files if encountered.
            If omitted the default behavior is not to unpack archives.
            
            For example, if a .arc file is encountered while iterating files the contents of the archive will be written to disk and a descriptive file of the archive will be generated.
            Note that this can potentially be a memory hog.
            """, defaultValue = "false")
    private boolean unpackArchives;

    @CommandLine.Option(names = {"-x", "--unpack-archives-exclusively"}, arity = "0..1", description = """
            Optionally specify whether to ignore all other file types and only unpack .arc files if encountered.
            Has no effect if specified by itself.
            If omitted the default behavior is to extract information for other file types as well.
            
            For example, if any file type other than .arc is encountered while iterating files they will be ignored.
            """, defaultValue = "false")
    private boolean unpackArchivesExclusively;

    @CommandLine.Option(names = {"-p", "--parallel"}, arity = "0..1", description = """
            Optionally specify whether to run extraction in parallel.
            If omitted the default behavior is to run in parallel.
            
            Turning this off improves legibility of logs and supports debugging.
            """, defaultValue = "true")
    private boolean runInParallel;

    @CommandLine.Option(names = {"-t", "--export-textures"}, arity = "0..1", description = """
            Optionally specify whether to export textures as DDS.
            If omitted the default behavior is to not export textures as DDS.
            
            Note that textures will be dumped as JSON or YAML without the data either way.
            """, defaultValue = "false")
    private boolean exportTextures;

    @CommandLine.Option(names = {"-i", "--ignore-extensions"}, arity = "0..1", description = """
            Optionally specify whether to ignore specific file extensions from parsing.
            If omitted the default behavior is parse all supported extensions.
            Example:
                resource -i .dds,.tex FILE outputs the data in a file relative to the current working directory based on the input file name.
            """, split = ",", defaultValue = "")
    private Set<String> ignoreExtensions;

    private static ClientResourceFileManager getClientResourceFileManager(Path clientRootFolder, Path clientTranslationFile, SerializationFormat preferredSerializationType, boolean shouldSerializeMetaInformation) {
        Path versionlist = clientRootFolder.resolve("dlinfo").resolve("versionlist");
        String versionlistString;
        ClientVersion clientVersion;
        try {
            versionlistString = Files.readString(versionlist);
            clientVersion = ClientVersion.of(Integer.parseInt(versionlistString.substring(0, 2)), Integer.parseInt(versionlistString.substring(2, 4)));
        } catch (IOException e) {
            throw new TechnicalException("Could not load DDON version file!", e);
        }
        log.info("Identified DDON client version v'{}'", versionlistString);

        return switch (clientVersion) {
            case VERSION_1_1 ->
                    new ClientResourceFileManagerSeason1(clientRootFolder, clientTranslationFile, preferredSerializationType, shouldSerializeMetaInformation);
            case VERSION_2_3 ->
                    new ClientResourceFileManagerSeason2(clientRootFolder, clientTranslationFile, preferredSerializationType, shouldSerializeMetaInformation);
            case VERSION_3_4 ->
                    new ClientResourceFileManagerSeason3(clientRootFolder, clientTranslationFile, preferredSerializationType, shouldSerializeMetaInformation);
        };
    }

    private StatusCode extractSingleFile(Path filePath, Serializer<Resource> serializer, boolean writeOutputToFile) {
        BufferReader bufferReader;
        try {
            bufferReader = new BinaryReader(filePath);
        } catch (IOException e) {
            log.error("Failed to read from the provided file path '{}'.", filePath);
            if (log.isDebugEnabled()) {
                log.error("", e);
            }
            return StatusCode.ERROR;
        }
        Resource deserializedOutput = clientResourceFileManager.deserialize(filePath, bufferReader);
        if (deserializedOutput == null) {
            log.error("File '{}' is not supported.", filePath);
            return StatusCode.ERROR;
        }
        log.debug("Extracting resource data from file '{}'.", filePath);
        String serializedOutput;
        try {
            serializedOutput = serializer.serialize(deserializedOutput);
        } catch (SerializerException e) {
            log.error("Failed to serialize object '{}'.", deserializedOutput);
            if (log.isDebugEnabled()) {
                log.error("", e);
            }
            return StatusCode.ERROR;
        }
        if (writeOutputToFile) {
            String fileName = filePath.getFileName().toString();
            String outputFile = fileName + "." + outputFormat;

            Path outputFolder = Path.of("output").resolve(filePath.subpath(0, filePath.getNameCount() - 1));
            boolean mkdirsSucceeded = outputFolder.toFile().mkdirs();
            if (!mkdirsSucceeded && !Files.isDirectory(outputFolder)) {
                log.error("Failed to create folders for output file.");
                return StatusCode.ERROR;
            }
            Path outputFilePath = outputFolder.resolve(outputFile);
            log.info("Outputting to file '{}'.", outputFilePath);

            try {
                if (exportTextures && (deserializedOutput instanceof Texture t)) {
                    DirectDrawSurface dds = t.toDirectDrawSurface();
                    Path ddsPath = outputFolder.resolve(fileName + ".dds");
                    byte[] ddsBytes = clientResourceFileManager.getSerializer(outputFile + ".dds", dds).serializeResource(dds);
                    boolean shouldWriteDds = true;
                    if (Files.exists(ddsPath)) {
                        try {
                            long existingSize = Files.size(ddsPath);
                            if (existingSize == ddsBytes.length) {
                                String newHash = DigestUtils.md5Hex(ddsBytes);
                                try (InputStream is = Files.newInputStream(ddsPath)) {
                                    String existingHash = DigestUtils.md5Hex(is);
                                    if (existingHash.equals(newHash)) {
                                        shouldWriteDds = false;
                                        log.debug("Skipping unchanged DDS file '{}'.", ddsPath);
                                    }
                                }
                            }
                        } catch (IOException e) {
                            log.warn("Failed to compare existing DDS file '{}', proceeding to overwrite.", ddsPath);
                        }
                    }
                    if (shouldWriteDds) {
                        Files.write(ddsPath, ddsBytes, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
                    }
                }

                // Hash-based skip for main serialized output
                byte[] newBytes = serializedOutput.getBytes(StandardCharsets.UTF_8);
                boolean shouldWriteMain = true;
                if (Files.exists(outputFilePath)) {
                    try {
                        long existingSize = Files.size(outputFilePath);
                        if (existingSize == newBytes.length) {
                            // Only compute hashes if sizes match to save some work
                            String newHash = DigestUtils.md5Hex(newBytes);
                            try (InputStream is = Files.newInputStream(outputFilePath)) {
                                String existingHash = DigestUtils.md5Hex(is);
                                if (newHash.equals(existingHash)) {
                                    shouldWriteMain = false;
                                    log.debug("Skipping unchanged output file '{}'.", outputFilePath);
                                }
                            }
                        }
                    } catch (IOException e) {
                        log.warn("Failed to compare existing file '{}', proceeding to overwrite.", outputFilePath);
                    }
                }

                if (shouldWriteMain) {
                    Files.writeString(outputFilePath, serializedOutput, StandardCharsets.UTF_8, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
                }

                if (unpackArchives && (deserializedOutput instanceof Archive archive)) {
                    outputFolder = outputFolder.resolve(fileName.substring(0, fileName.lastIndexOf('.')));
                    for (Map.Entry<String, byte[]> entry : archive.getResourceFiles().entrySet()) {
                        String arcFile = entry.getKey();
                        byte[] bytes = entry.getValue();
                        Path arcFilePath = Paths.get(arcFile);
                        Path arcOutputFolder = outputFolder.resolve(arcFilePath.subpath(0, Math.max(1, arcFilePath.getNameCount() - 1)));
                        boolean arcMkdirsSucceeded = arcOutputFolder.toFile().mkdirs();
                        if (!arcMkdirsSucceeded && !Files.isDirectory(arcOutputFolder)) {
                            log.error("Failed to create folders for arc file.");
                            return StatusCode.ERROR;
                        }
                        Path arcOutputFilePath = arcOutputFolder.resolve(arcFilePath.getFileName());
                        log.info("Outputting to file '{}'.", arcOutputFilePath);
                        Files.write(arcOutputFilePath, bytes, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
                    }
                }
            } catch (IOException e) {
                log.error("Failed to write file '{}'", outputFilePath);
                if (log.isDebugEnabled()) {
                    log.error("", e);
                }
                return StatusCode.ERROR;
            }
        } else {
            log.debug("Outputting to console.");
            log.info(serializedOutput);
        }
        return StatusCode.OK;
    }

    @Override
    public Integer call() throws Exception {
        Path fullPath = clientRootFolder.resolve("nativePC").resolve("rom").resolve(inputFilePath);
        if (Files.exists(fullPath)) {
            clientResourceFileManager = getClientResourceFileManager(clientRootFolder, clientTranslationFile, outputFormat, addMetaInformation);
            if (Files.isDirectory(fullPath)) {
                log.debug("Recursively extracting resource data from folder '{}'.", fullPath);
                try (Stream<Path> files = Files.walk(fullPath)) {
                    Predicate<Path> fileFilter;
                    if (unpackArchives && unpackArchivesExclusively) {
                        String arcFileExtension = ClientResourceFileExtension.getFileExtensions(ClientResourceFileExtension.rArchive);
                        fileFilter = path -> {
                            String fileName = path.getFileName().toString();
                            return fileName.endsWith(arcFileExtension);
                        };
                    } else {
                        Set<String> supportedFileExtensions = ClientResourceFileExtension.getSupportedFileExtensions();
                        supportedFileExtensions.removeAll(ignoreExtensions);
                        fileFilter = path -> {
                            String fileName = path.getFileName().toString();
                            return supportedFileExtensions.stream().anyMatch(fileName::endsWith);
                        };
                    }
                    Stream<Path> filePathStream;
                    if (runInParallel) {
                        filePathStream = files.toList().parallelStream();
                    } else {
                        filePathStream = files.toList().stream();
                    }
                    List<StatusCode> statusCodes = filePathStream
                            .filter(fileFilter)
                            .map(path -> extractSingleFile(path, clientResourceFileManager.getStringSerializer(), writeOutputToFile)).toList();
                    if (statusCodes.contains(StatusCode.ERROR)) {
                        log.warn("Failed to resource one or more resource files.");
                        return StatusCode.ERROR.ordinal();
                    } else {
                        log.info("Extracted all resource files.");
                        return StatusCode.OK.ordinal();
                    }
                }
            } else {
                return extractSingleFile(fullPath, clientResourceFileManager.getStringSerializer(), writeOutputToFile).ordinal();
            }
        } else {
            log.error("The provided file path '{}' does either not exist or is not readable.", fullPath);
            return StatusCode.ERROR.ordinal();
        }
    }
}
