package org.sehkah.doon.tools.extractor.lib.logic.deserialization.game_common;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ExtensionMap;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.FileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.game_common.EnemyGroup;

public class EnemyGroupDeserializer extends FileDeserializer {
    public EnemyGroupDeserializer(FileReader fileReader) {
        super(ExtensionMap.rEnemyGroup, fileReader);
    }

    private static EnemyGroup readEntity(FileReader fileReader) {
        return new EnemyGroup(
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readArray(FileReader::readUnsignedInteger)
        );
    }

    @Override
    protected Object readObject() {
        return fileReader.readArray(EnemyGroupDeserializer::readEntity);
    }
}
