package org.sehkah.doon.tools.extractor.lib.logic.reserialization.game_common;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.sehkah.doon.tools.extractor.lib.common.io.BinaryFileReader;
import org.sehkah.doon.tools.extractor.lib.logic.reserialization.Reserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.game_common.EnemyGroup;

import java.util.List;

public class EnemyGroupReserializer implements Reserializer {
    private static final Logger logger = LogManager.getLogger();
    public static final EnemyGroupReserializer INSTANCE = new EnemyGroupReserializer();

    private EnemyGroupReserializer() {

    }

    public Object deserialize(BinaryFileReader binaryFileReader) {
        return deserializeEnemyGroup(binaryFileReader);
    }

    public static List<EnemyGroup> deserializeEnemyGroup(BinaryFileReader binaryFileReader) {
        long version = binaryFileReader.readUnsignedInteger();
        logger.info("version: '{}'", version);
        return binaryFileReader.readArray(EnemyGroupReserializer::readEnemyGroup);
    }

    private static EnemyGroup readEnemyGroup(BinaryFileReader reader) {
        return new EnemyGroup(
                reader.readUnsignedInteger(),
                reader.readUnsignedInteger(),
                reader.readArray(BinaryFileReader::readUnsignedInteger)
        );
    }
}
