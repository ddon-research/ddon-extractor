package org.sehkah.doon.tools.extractor.lib.logic.deserialization.game_common;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.Deserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.game_common.EnemyGroup;

import java.util.List;

public class EnemyGroupDeserializer implements Deserializer {
    public static final EnemyGroupDeserializer INSTANCE = new EnemyGroupDeserializer();
    private static final Logger logger = LogManager.getLogger();

    private EnemyGroupDeserializer() {

    }

    public static List<EnemyGroup> deserializeObject(FileReader fileReader) {
        long version = fileReader.readUnsignedInteger();
        logger.info("version: '{}'", version);
        return fileReader.readArray(EnemyGroupDeserializer::readEntity);
    }

    private static EnemyGroup readEntity(FileReader reader) {
        return new EnemyGroup(
                reader.readUnsignedInteger(),
                reader.readUnsignedInteger(),
                reader.readArray(FileReader::readUnsignedInteger)
        );
    }

    @Override
    public Object deserialize(FileReader fileReader) {
        return deserializeObject(fileReader);
    }
}
