package org.sehkah.ddon.tools.extractor.cli.logic;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.sehkah.ddon.tools.extractor.cli.common.StatusCode;
import org.sehkah.doon.tools.extractor.lib.common.error.SerializationException;
import org.sehkah.doon.tools.extractor.lib.common.io.BinaryFileReader;
import org.sehkah.doon.tools.extractor.lib.common.serialization.SerializationFormat;
import org.sehkah.doon.tools.extractor.lib.common.serialization.Serializer;
import org.sehkah.doon.tools.extractor.lib.common.serialization.SerializerImpl;
import org.sehkah.doon.tools.extractor.lib.logic.reserialization.Reserializer;
import org.sehkah.doon.tools.extractor.lib.logic.reserialization.ReserializerFactory;
import picocli.CommandLine;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.stream.Stream;

@CommandLine.Command(name = "extract", mixinStandardHelpOptions = true, version = "extract 1.0",
        description = "Prints the provided DDON resource file to STDOUT.")
public class ExtractCommand implements Callable<Integer> {
    private static final Logger logger = LogManager.getLogger();

    @CommandLine.Parameters(index = "0", arity = "1", description = """
            Specifies the DDON client resource file whose data to extract or a folder to recursively search for such files.
            Example:
                extract "D:\\DDON_03040008\\nativePC\\rom\\game_common\\param\\enemy_group.emg" will extract the data of the enemy_group.emg resource file.
                extract "D:\\DDON_03040008\\nativePC\\rom\\game_common\\param" will extract the data of all resource files found in this path.
            """)
    private Path inputFilePath;

    @CommandLine.Option(names = {"-f", "--format"}, arity = "0..1", description = """
            Optionally specify the output format (${COMPLETION-CANDIDATES}).
            If omitted the default format is used (YAML).
            Example:
                 extract --format=JSON FILE  outputs the data with the JSON format on the console
                 extract --format FILE   outputs the data with the default format on the console"
            """, defaultValue = "YAML")
    private final SerializationFormat outputFormat = SerializationFormat.DEFAULT;
    @CommandLine.Option(names = {"-o"}, arity = "0..1", description = """
            Optionally specify whether to output the extracted data as a file.
            Example:
                extract -o FILE outputs the data in a file relative to the current working directory based on the input file name.
            """, defaultValue = "false")
    private boolean writeOutputToFile;

    @Override
    public Integer call() throws Exception {
        if (Files.exists(inputFilePath) && Files.isReadable(inputFilePath)) {
            if (Files.isDirectory(inputFilePath)) {
                logger.debug("Recursively extracting resource data from folder: {}", inputFilePath);
                try (Stream<Path> files = Files.walk(inputFilePath)) {
                    List<StatusCode> statusCodes = files.map(path -> extractSingleFile(path, outputFormat, writeOutputToFile)).toList();
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
                return extractSingleFile(inputFilePath, outputFormat, writeOutputToFile).ordinal();
            }
        } else {
            logger.error("The provided file path '{}' does either not exist or is not readable.", inputFilePath);
            return StatusCode.ERROR.ordinal();
        }
    }

    private static StatusCode extractSingleFile(Path filePath, SerializationFormat outputFormat, boolean writeOutputToFile) {
        BinaryFileReader binaryFileReader;
        try {
            binaryFileReader = BinaryFileReader.inMemoryFromFilePath(filePath);
        } catch (IOException e) {
            logger.error("Failed to read from the provided file path: {}", filePath);
            if (logger.isDebugEnabled()) {
                logger.error(e);
            }
            return StatusCode.ERROR;
        }
        Reserializer reserializer = ReserializerFactory.forFilePath(filePath);
        if (reserializer == null) {
            return StatusCode.ERROR;
        }
        Object deserializedOutput = reserializer.deserialize(binaryFileReader);

        if (deserializedOutput != null) {
            Serializer serializer = new SerializerImpl(outputFormat);
            String serializedOutput;
            try {
                serializedOutput = serializer.serialize(deserializedOutput);
            } catch (SerializationException e) {
                logger.error("Failed to serialize object: {}", deserializedOutput);
                if (logger.isDebugEnabled()) {
                    logger.error(e);
                }
                return StatusCode.ERROR;
            }
            if (writeOutputToFile) {
                String outputFile = filePath.getFileName() + "." + outputFormat.name().toLowerCase();
                Path outputFilePath = Path.of(".").resolve(outputFile);
                logger.debug("Outputting to file: {}", outputFilePath);
                try {
                    Files.write(outputFilePath, serializedOutput.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
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
}
