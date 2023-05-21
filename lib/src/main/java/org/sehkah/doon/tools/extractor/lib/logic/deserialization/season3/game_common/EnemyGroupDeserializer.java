package org.sehkah.doon.tools.extractor.lib.logic.deserialization.season3.game_common;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.ClientResourceFile;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ClientResourceFileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.season3.game_common.EnemyGroup;
import org.sehkah.doon.tools.extractor.lib.logic.entity.season3.game_common.EnemyGroupList;

public class EnemyGroupDeserializer extends ClientResourceFileDeserializer {
    public EnemyGroupDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static EnemyGroup readEnemyGroup(FileReader fileReader) {
        return new EnemyGroup(
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readArray(FileReader::readUnsignedInteger)
        );
    }

    @Override
    protected EnemyGroupList parseClientResourceFile(FileReader fileReader) {
        return new EnemyGroupList(fileReader.readArray(EnemyGroupDeserializer::readEnemyGroup));
    }
}
