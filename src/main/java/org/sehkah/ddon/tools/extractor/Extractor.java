package org.sehkah.ddon.tools.extractor;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.sehkah.ddon.tools.common.io.BinaryFileReader;
import org.sehkah.ddon.tools.common.serialization.Serializer;
import org.sehkah.ddon.tools.common.serialization.SerializerImpl;
import org.sehkah.ddon.tools.common.serialization.SupportedSerializationTypes;
import org.sehkah.ddon.tools.extractor.logic.game_common.EnemyGroupReserializer;
import org.sehkah.ddon.tools.extractor.model.SupportedExtractionTypes;
import picocli.CommandLine;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Objects;
import java.util.concurrent.Callable;

import static org.sehkah.ddon.tools.extractor.model.SupportedExtractionTypes.ENEMY_GROUP;

@CommandLine.Command(name = "extract", mixinStandardHelpOptions = true, version = "extract 1.0",
        description = "Prints the provided DDON resource file to STDOUT.")
public class Extractor implements Callable<Integer> {
    private static final Logger logger = LogManager.getLogger();

    @CommandLine.Parameters(index = "0", arity = "1", description = """
            Specifies the DDON client resource file whose data to extract.
            Example:
                extract "D:\\DDON_03040008\\nativePC\\rom\\game_common\\param\\enemy_group.emg" will extract the data of the enemy_group.emg resource file.
            """)
    private Path inputFilePath;

    @CommandLine.Option(names = {"-f", "--format"}, arity = "0..1", description = """
            Optionally specify the output format (${COMPLETION-CANDIDATES}).
            If omitted the default format is used (YAML).
            Example:
                 extract --format=JSON FILE  outputs the data with the JSON format on the console
                 extract --format FILE   outputs the data with the default format on the console"
            """, defaultValue = "YAML")
    private SupportedSerializationTypes outputFormat = SupportedSerializationTypes.DEFAULT;
    @CommandLine.Option(names = {"-o"}, arity = "0..1", description = """
            Optionally specify whether to output the extracted data as a file.
            Example:
                extract -o FILE outputs the data in a file relative to the current working directory based on the input file name.
            """, defaultValue = "false")
    private boolean writeOutputToFile;

    @Override
    public Integer call() throws Exception {
        Serializer serializer = new SerializerImpl(outputFormat);

        SupportedExtractionTypes extractionType = SupportedExtractionTypes.findByFilePath(inputFilePath);
        if (Objects.requireNonNull(extractionType) == SupportedExtractionTypes.UNSUPPORTED) {
            logger.info("The provided path '{}' did not match any supported extraction types.", inputFilePath);
            return 1;
        }

        BinaryFileReader binaryFileReader = BinaryFileReader.inMemoryFromFilePath(inputFilePath);
        Object deserializedOutput = null;

        if (extractionType == ENEMY_GROUP) {
            logger.info("Found a matching extraction type for the provided path '{}' with {}", inputFilePath, ENEMY_GROUP.name());
            deserializedOutput = EnemyGroupReserializer.deserialize(binaryFileReader);
        }

        if (deserializedOutput != null) {
            String serializedOutput = serializer.serialize(deserializedOutput);
            if (writeOutputToFile) {
                Files.write(Path.of(".").resolve(inputFilePath.getFileName() + "." + outputFormat.name().toLowerCase()), serializedOutput.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
            } else {
                logger.info(serializedOutput);
            }
            return 0;
        } else {
            logger.error("Reserialization has failed.");
            return 1;
        }
    }
}
