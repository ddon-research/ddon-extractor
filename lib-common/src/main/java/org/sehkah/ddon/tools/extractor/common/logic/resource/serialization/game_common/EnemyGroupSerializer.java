package org.sehkah.ddon.tools.extractor.common.logic.resource.serialization.game_common;

import org.sehkah.ddon.tools.extractor.api.io.BufferWriter;
import org.sehkah.ddon.tools.extractor.api.logic.resource.serialization.ClientResourceFileSerializer;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.game_common.EnemyGroup;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.game_common.EnemyGroupList;

public class EnemyGroupSerializer extends ClientResourceFileSerializer<EnemyGroupList> {

    private static void writeEnemyGroup(EnemyGroup enemyGroup, BufferWriter bufferWriter) {
        bufferWriter.writeUnsignedInteger(enemyGroup.getEnemyGroupId());
        bufferWriter.writeUnsignedInteger(enemyGroup.getMsgIndex());
        bufferWriter.writeArray(enemyGroup.getEmList(), () -> bufferWriter::writeUnsignedInteger);
    }

    @Override
    protected void serializeClientResourceFile(EnemyGroupList clientResource, BufferWriter bufferWriter) {
        bufferWriter.writeUnsignedInteger(clientResource.getEnemyGroupList().size());
        clientResource.getEnemyGroupList().forEach(enemyGroup -> writeEnemyGroup(enemyGroup, bufferWriter));
    }
}
