package org.sehkah.ddon.tools.extractor.season3.logic.resource.deserialization.game_common;

import org.sehkah.ddon.tools.extractor.lib.common.io.BufferReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.game_common.EnemyGroup;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.game_common.EnemyGroupList;

public class EnemyGroupDeserializer extends ClientResourceFileDeserializer {
    public EnemyGroupDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static EnemyGroup readEnemyGroup(BufferReader bufferReader) {
        return new EnemyGroup(
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readArray(BufferReader::readUnsignedInteger)
        );
    }

    @Override
    protected EnemyGroupList parseClientResourceFile(BufferReader bufferReader) {
        return new EnemyGroupList(bufferReader.readArray(EnemyGroupDeserializer::readEnemyGroup));
    }
}
