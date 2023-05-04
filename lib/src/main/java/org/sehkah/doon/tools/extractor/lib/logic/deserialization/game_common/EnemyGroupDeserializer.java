package org.sehkah.doon.tools.extractor.lib.logic.deserialization.game_common;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ExtractionType;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.FileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.game_common.EnemyGroup;

public class EnemyGroupDeserializer extends FileDeserializer {
    public EnemyGroupDeserializer(FileReader fileReader) {
        super(ExtractionType.ENEMY_GROUP, fileReader);
    }

    private static EnemyGroup readEntity(FileReader reader) {
        return new EnemyGroup(
                reader.readUnsignedInteger(),
                reader.readUnsignedInteger(),
                reader.readArray(FileReader::readUnsignedInteger)
        );
    }

    @Override
    public Object deserialize() {
        if (!isVersionValid()) {
            return null;
        }
        return fileReader.readArray(EnemyGroupDeserializer::readEntity);
    }
}
