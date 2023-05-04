package org.sehkah.doon.tools.extractor.lib.logic.reserialization;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.sehkah.doon.tools.extractor.lib.logic.reserialization.game_common.EnemyGroupReserializer;

import java.nio.file.Path;
import java.util.Objects;

import static org.sehkah.doon.tools.extractor.lib.logic.reserialization.ExtractionType.ENEMY_GROUP;


public class ReserializerFactory {
    private static final Logger logger = LogManager.getLogger();

    private ReserializerFactory() {
    }

    public static Reserializer instantiate(ExtractionType extractionType) {
        Reserializer instance = null;
        if (extractionType == ENEMY_GROUP) {
            instance = EnemyGroupReserializer.INSTANCE;
        }
        return instance;
    }

    public static Reserializer forFilePath(Path filePath) {
        ExtractionType extractionType = ExtractionType.findByFilePath(filePath);
        if (Objects.requireNonNull(extractionType) == ExtractionType.UNSUPPORTED) {
            logger.error("The provided file path '{}' did not match any supported extraction types.", filePath);
            return null;
        }
        Reserializer instance =  instantiate(extractionType);
        if (instance != null) {
            logger.info("The provided file path '{}' matches extraction type '{}'.", filePath, extractionType.name());
        } else {
            logger.info("Could not find a suitable implementation for extraction type '{}'.", extractionType.name());
        }
        return instance;
    }
}
