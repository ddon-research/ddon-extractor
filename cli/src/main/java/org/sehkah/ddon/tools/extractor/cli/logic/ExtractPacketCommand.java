package org.sehkah.ddon.tools.extractor.cli.logic;

import lombok.extern.slf4j.Slf4j;
import org.sehkah.ddon.tools.extractor.cli.common.command.StatusCode;
import org.sehkah.ddon.tools.extractor.lib.common.error.SerializerException;
import org.sehkah.ddon.tools.extractor.lib.common.error.TechnicalException;
import org.sehkah.ddon.tools.extractor.lib.common.io.BinaryReader;
import org.sehkah.ddon.tools.extractor.lib.common.io.BufferReader;
import org.sehkah.ddon.tools.extractor.lib.common.packet.Packet;
import org.sehkah.ddon.tools.extractor.lib.common.serialization.SerializationFormat;
import org.sehkah.ddon.tools.extractor.lib.common.serialization.Serializer;
import org.sehkah.ddon.tools.extractor.lib.logic.packet.deserialization.PacketBufferDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.packet.deserialization.PacketFileExtension;
import org.sehkah.ddon.tools.extractor.lib.logic.packet.deserialization.PacketManager;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientVersion;
import org.sehkah.ddon.tools.extractor.season3.logic.packet.PacketManagerSeason3;
import picocli.CommandLine;

import java.io.IOException;
import java.nio.ByteOrder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.function.Predicate;
import java.util.stream.Stream;

@Slf4j
@CommandLine.Command(name = "packet", mixinStandardHelpOptions = true, version = "extract 1.0",
        description = "Extracts the provided DDON packet file(s).")
public class ExtractPacketCommand implements Callable<Integer> {
    private PacketManager packetManager;

    @CommandLine.Option(names = {"-f", "--format"}, arity = "0..1", description = """
            Optionally specify the output format (${COMPLETION-CANDIDATES}).
            If omitted the default format is used (json).
            Example:
                 extract-packet --format=JSON FILE  outputs the data with the JSON format on the console
                 extract-packet --format FILE   outputs the data with the default format on the console"
            """, defaultValue = "json")
    private SerializationFormat outputFormat;

    @CommandLine.Parameters(index = "0", arity = "1", description = """
            Specifies the DDON client resource file path.
            This will be used as a basis to derive further meta information for certain packet files where supported and enabled.
            See the meta information flag for further information
            Example:
                extract "D:\\DDON\\nativePC\\rom" <resource file>
            """)
    private Path clientRootFolder;

    @CommandLine.Parameters(index = "1", arity = "1", description = """
            Specifies the DDON packet file whose data to extract or a folder to recursively search for such files.
            The full path must be specified.
            Example:
                extract-packet <client resource base path> "D:\\packets\\C2L_LOGIN_REQ.packet" will extract the data of the C2L_LOGIN_REQ.packet packet file.
                extract-packet <client resource base path> "D:\\packets" will extract the data of all packet files found in this path.
            """)
    private Path inputFilePath;
    @CommandLine.Option(names = {"-o"}, arity = "0..1", description = """
            Optionally specify whether to output the extracted data as a file.
            If omitted the default behavior is to output to console.
            Example:
                extract-packet -o FILE outputs the data in a file relative to the current working directory based on the input file name.
            """, defaultValue = "false")
    private boolean writeOutputToFile;

    @CommandLine.Option(names = {"-m", "--meta-information"}, arity = "0..1", description = """
            Optionally specify whether to enrich the output with additional meta information (if available).
            If omitted the default behavior is not to add meta information.
                        
            For example, if a numeric type has a corresponding (probable) semantic mapping this will be output as additional field.
            Note that this makes the output more comprehensible at the price of serialization compatibility and accuracy.
            """, defaultValue = "false")
    private boolean addMetaInformation;

    @CommandLine.Option(names = {"-p", "--parallel"}, arity = "0..1", description = """
            Optionally specify whether to run extraction in parallel.
            If omitted the default behavior is to run in parallel.
                        
            Turning this off improves legibility of logs and supports debugging.
            """, defaultValue = "true")
    private boolean runInParallel;

    private StatusCode extractSingleFile(Path filePath, Serializer<Packet> serializer, boolean writeOutputToFile) {
        BufferReader bufferReader;
        try {
            bufferReader = new BinaryReader(filePath, ByteOrder.BIG_ENDIAN);
        } catch (IOException e) {
            log.error("Failed to read from the provided file path '{}'.", filePath);
            if (log.isDebugEnabled()) {
                log.error("", e);
            }
            return StatusCode.ERROR;
        }
        String fileName = filePath.getFileName().toString();
        PacketBufferDeserializer<Packet> packetBufferDeserializer = packetManager.getDeserializer(bufferReader);
        if (packetBufferDeserializer == null) {
            log.error("Packet '{}' is not supported.", fileName);
            return StatusCode.ERROR;
        }
        log.debug("Extracting packet data from file '{}'.", filePath);
        Packet deserializedOutput = packetBufferDeserializer.deserialize(bufferReader);
        if (deserializedOutput != null) {
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
                    Files.writeString(outputFilePath, serializedOutput, StandardCharsets.UTF_8, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
                } catch (IOException e) {
                    log.error("Failed to write file '{}'.", outputFilePath);
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
        } else {
            log.error("Deserialization has failed.");
            return StatusCode.ERROR;
        }
    }

    private static PacketManager getPacketManager(Path clientRootFolder, SerializationFormat preferredSerializationType, boolean shouldSerializeMetaInformation) {
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
                    null;
            case VERSION_2_3 ->
                    null;
            case VERSION_3_4 ->
                    new PacketManagerSeason3(clientRootFolder, preferredSerializationType, shouldSerializeMetaInformation);
        };
    }

    @Override
    public Integer call() throws Exception {
        Path fullPath = inputFilePath;
        if (Files.exists(fullPath)) {
            packetManager = getPacketManager(clientRootFolder, outputFormat, addMetaInformation);
            if (Files.isDirectory(fullPath)) {
                log.debug("Recursively extracting resource data from folder '{}'.", fullPath);
                try (Stream<Path> files = Files.walk(fullPath)) {
                    Predicate<Path> fileFilter;
                    Set<String> supportedFileExtensions = PacketFileExtension.getSupportedFileExtensions();
                    fileFilter = path -> {
                        String fileName = path.getFileName().toString();
                        return supportedFileExtensions.stream().anyMatch(fileName::endsWith);
                    };
                    Stream<Path> filePathStream;
                    if (runInParallel) {
                        filePathStream = files.toList().parallelStream();
                    } else {
                        filePathStream = files.toList().stream();
                    }
                    List<StatusCode> statusCodes = filePathStream
                            .filter(fileFilter)
                            .map(path -> extractSingleFile(path, packetManager.getStringSerializer(), writeOutputToFile)).toList();
                    if (statusCodes.contains(StatusCode.ERROR)) {
                        log.warn("Failed to extract one or more resource files.");
                        return StatusCode.ERROR.ordinal();
                    } else {
                        log.info("Extracted all resource files.");
                        return StatusCode.OK.ordinal();
                    }
                }
            } else {
                return extractSingleFile(fullPath, packetManager.getStringSerializer(), writeOutputToFile).ordinal();
            }
        } else {
            log.error("The provided file path '{}' does either not exist or is not readable.", fullPath);
            return StatusCode.ERROR.ordinal();
        }
    }
}
