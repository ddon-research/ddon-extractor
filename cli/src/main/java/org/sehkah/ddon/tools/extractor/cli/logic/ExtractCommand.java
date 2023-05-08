package org.sehkah.ddon.tools.extractor.cli.logic;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.sehkah.ddon.tools.extractor.cli.common.command.StatusCode;
import org.sehkah.doon.tools.extractor.lib.common.error.SerializerException;
import org.sehkah.doon.tools.extractor.lib.common.io.BinaryFileReader;
import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.Deserializer;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.DeserializerFactory;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ClientResourceFile;
import org.sehkah.doon.tools.extractor.lib.logic.serialization.SerializationFormat;
import org.sehkah.doon.tools.extractor.lib.logic.serialization.Serializer;
import org.sehkah.doon.tools.extractor.lib.logic.serialization.SerializerImpl;
import picocli.CommandLine;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.stream.Stream;

@CommandLine.Command(name = "extract", mixinStandardHelpOptions = true, version = "extract 1.0",
        description = "Prints the provided DDON resource file to STDOUT.")
public class ExtractCommand implements Callable<Integer> {
    private final Logger logger = LogManager.getLogger(ExtractCommand.class);
    private final DeserializerFactory deserializerFactory = new DeserializerFactory();
    @CommandLine.Option(names = {"-f", "--format"}, arity = "0..1", description = """
            Optionally specify the output format (${COMPLETION-CANDIDATES}).
            If omitted the default format is used (YAML).
            Example:
                 extract --format=JSON FILE  outputs the data with the JSON format on the console
                 extract --format FILE   outputs the data with the default format on the console"
            """, defaultValue = "YAML")
    private final SerializationFormat outputFormat = SerializationFormat.DEFAULT;
    @CommandLine.Parameters(index = "0", arity = "1", description = """
            Specifies the DDON client resource file whose data to extract or a folder to recursively search for such files.
            Example:
                extract "D:\\DDON_03040008\\nativePC\\rom\\game_common\\param\\enemy_group.emg" will extract the data of the enemy_group.emg resource file.
                extract "D:\\DDON_03040008\\nativePC\\rom\\game_common\\param" will extract the data of all resource files found in this path.
            """)
    private Path inputFilePath;
    @CommandLine.Option(names = {"-o"}, arity = "0..1", description = """
            Optionally specify whether to output the extracted data as a file.
            Example:
                extract -o FILE outputs the data in a file relative to the current working directory based on the input file name.
            """, defaultValue = "false")
    private boolean writeOutputToFile;

    @CommandLine.Option(names = {"-m", "--meta-information"}, arity = "0..1", description = """
            Optionally specify whether to enrich the output with additional meta information (if available).
            For example, if a numeric type has a corresponding (probable) semantic mapping this will be output as additional field.
            Note that this makes the output more comprehensible at the price of compatibility and accuracy.
            """, defaultValue = "false")
    private boolean addMetaInformation;

    private StatusCode extractSingleFile(Path filePath, Serializer serializer, boolean writeOutputToFile) {
        FileReader fileReader;
        try {
            fileReader = new BinaryFileReader(filePath);
        } catch (IOException e) {
            logger.error("Failed to read from the provided file path: {}", filePath);
            if (logger.isDebugEnabled()) {
                logger.error(e);
            }
            return StatusCode.ERROR;
        }
        Deserializer<?> deserializer = deserializerFactory.forFilePath(filePath);
        if (deserializer == null) {
            return StatusCode.ERROR;
        }
        Object deserializedOutput = deserializer.deserialize(fileReader);
        if (deserializedOutput != null) {
            String serializedOutput;
            try {
                serializedOutput = serializer.serialize(deserializedOutput);
            } catch (SerializerException e) {
                logger.error("Failed to serialize object: {}", deserializedOutput);
                if (logger.isDebugEnabled()) {
                    logger.error(e);
                }
                return StatusCode.ERROR;
            }
            if (writeOutputToFile) {
                String outputFile = filePath.getFileName() + "." + outputFormat.name().toLowerCase();
                Path outputFolder = Path.of("output").resolve(filePath.subpath(3, filePath.getNameCount() - 1));
                boolean mkdirsSucceeded = outputFolder.toFile().mkdirs();
                if (!mkdirsSucceeded && !Files.isDirectory(outputFolder)) {
                    logger.error("Failed to create folders for output file.");
                    return StatusCode.ERROR;
                }
                Path outputFilePath = outputFolder.resolve(outputFile);
                logger.debug("Outputting to file: {}", outputFilePath);
                try {
                    Files.writeString(outputFilePath, serializedOutput, StandardCharsets.UTF_8, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
                } catch (IOException e) {
                    logger.error("Failed to write file: {}", outputFilePath);
                    if (logger.isDebugEnabled()) {
                        logger.error(e);
                    }
                    return StatusCode.ERROR;
                }
            } else {
                logger.debug("Outputting to console.");
                logger.info(serializedOutput);
            }
            return StatusCode.OK;
        } else {
            logger.error("Deserialization has failed.");
            return StatusCode.ERROR;
        }
    }

    @Override
    public Integer call() throws Exception {
        if (Files.exists(inputFilePath) && Files.isReadable(inputFilePath)) {
            Serializer serializer = new SerializerImpl(outputFormat, addMetaInformation);
            if (Files.isDirectory(inputFilePath)) {
                logger.debug("Recursively extracting resource data from folder: {}", inputFilePath);
                try (Stream<Path> files = Files.walk(inputFilePath)) {
                    List<String> supportedFileExtensions = ClientResourceFile.getSupportedFileExtensions();
                    List<StatusCode> statusCodes = files
                            .filter(path -> {
                                String fileName = path.getFileName().toString();
                                return supportedFileExtensions.stream().anyMatch(fileName::endsWith);
                            })
                            .map(path -> extractSingleFile(path, serializer, writeOutputToFile)).toList();
                    if (statusCodes.contains(StatusCode.ERROR)) {
                        logger.warn("Failed to extract one or more resource files.");
                        return StatusCode.ERROR.ordinal();
                    } else {
                        logger.info("Extracted all resource files.");
                        return StatusCode.OK.ordinal();
                    }
                }
            } else {
                logger.debug("Extracting resource data from file: {}", inputFilePath);
                return extractSingleFile(inputFilePath, serializer, writeOutputToFile).ordinal();
            }
        } else {
            logger.error("The provided file path '{}' does either not exist or is not readable.", inputFilePath);
            return StatusCode.ERROR.ordinal();
        }
    }
}
