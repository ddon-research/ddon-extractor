package org.sehkah.doon.tools.extractor.lib.logic.reserialization;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.sehkah.doon.tools.extractor.lib.logic.reserialization.game_common.EnemyGroupDeserializer;

import java.nio.file.Path;
import java.util.Objects;

import static org.sehkah.doon.tools.extractor.lib.logic.reserialization.ExtractionType.ENEMY_GROUP;


public class DeserializerFactory {
    private static final Logger logger = LogManager.getLogger();

    private DeserializerFactory() {
    }

    public static Deserializer instantiate(ExtractionType extractionType) {
        Deserializer instance = null;
        if (extractionType == ENEMY_GROUP) {
            instance = EnemyGroupDeserializer.INSTANCE;
        }
        return instance;
    }

    public static Deserializer forFilePath(Path filePath) {
        ExtractionType extractionType = ExtractionType.findByFilePath(filePath);
        if (Objects.requireNonNull(extractionType) == ExtractionType.UNSUPPORTED) {
            logger.error("The provided file path '{}' did not match any supported extraction types.", filePath);
            return null;
        }
        Deserializer instance = instantiate(extractionType);
        if (instance != null) {
            logger.info("The provided file path '{}' matches extraction type '{}'.", filePath, extractionType.name());
        } else {
            logger.info("Could not find a suitable implementation for extraction type '{}'.", extractionType.name());
        }
        return instance;
    }
}
