package org.sehkah.ddon.tools.extractor.lib.logic.resource.serialization.season3.game_common;

import org.sehkah.ddon.tools.extractor.lib.common.io.BufferWriter;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.game_common.EnemyGroup;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.game_common.EnemyGroupList;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.serialization.ClientResourceFileSerializer;

public class EnemyGroupSerializer extends ClientResourceFileSerializer<EnemyGroupList> {

    private static void writeEnemyGroup(EnemyGroup enemyGroup, BufferWriter bufferWriter) {
        bufferWriter.writeUnsignedInteger(enemyGroup.EnemyGroupId());
        bufferWriter.writeUnsignedInteger(enemyGroup.MsgIndex());
        bufferWriter.writeArray(enemyGroup.EmList(), () -> bufferWriter::writeUnsignedInteger);
    }

    @Override
    protected void serializeClientResourceFile(EnemyGroupList clientResource, BufferWriter bufferWriter) {
        bufferWriter.writeUnsignedInteger(clientResource.getEnemyGroupList().size());
        clientResource.getEnemyGroupList().forEach(enemyGroup -> writeEnemyGroup(enemyGroup, bufferWriter));
    }
}
