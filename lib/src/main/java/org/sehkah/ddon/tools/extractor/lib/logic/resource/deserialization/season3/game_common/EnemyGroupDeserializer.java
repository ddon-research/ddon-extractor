package org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.season3.game_common;

import org.sehkah.ddon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.game_common.EnemyGroup;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.game_common.EnemyGroupList;

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
