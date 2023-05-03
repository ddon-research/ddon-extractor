package org.sehkah.ddon.tools.extractor.logic.game_common;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.sehkah.ddon.tools.common.io.BinaryFileReader;
import org.sehkah.ddon.tools.extractor.model.game_common.EnemyGroup;

import java.util.List;

public class EnemyGroupReserializer {
    private static final Logger logger = LogManager.getLogger();

    public static List<EnemyGroup> deserialize(BinaryFileReader binaryFileReader){
        long version = binaryFileReader.readSignedInteger();
        logger.info("version: '{}'", version);
        return binaryFileReader.readArray(EnemyGroupReserializer::readEnemyGroup);
    }

    private static EnemyGroup readEnemyGroup(BinaryFileReader reader) {
        return new EnemyGroup(
                reader.readUnsignedInteger(),
                reader.readSignedInteger(),
                reader.readArray(BinaryFileReader::readUnsignedInteger)
        );
    }
}
