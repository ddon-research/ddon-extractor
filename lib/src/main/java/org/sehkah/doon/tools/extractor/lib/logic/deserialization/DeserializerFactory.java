package org.sehkah.doon.tools.extractor.lib.logic.deserialization;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.nio.file.Path;
import java.util.Objects;


public class DeserializerFactory {
    private static final Logger logger = LogManager.getLogger();

    private DeserializerFactory() {
    }

    public static Deserializer forFilePath(Path filePath) {
        ExtractionType extractionType = ExtractionType.findByFilePath(filePath);
        if (Objects.requireNonNull(extractionType) == ExtractionType.UNSUPPORTED) {
            logger.error("The provided file path '{}' did not match any supported extraction types.", filePath);
            return null;
        }
        Deserializer instance = extractionType.deserializer;
        if (instance != null) {
            logger.info("The provided file path '{}' matches extraction type '{}'.", filePath, extractionType.name());
        } else {
            logger.info("Could not find a suitable implementation for extraction type '{}'.", extractionType.name());
        }
        return instance;
    }
}
