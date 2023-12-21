package org.sehkah.ddon.tools.extractor.lib.logic.serialization.season3.game_common;

import org.sehkah.ddon.tools.extractor.lib.common.io.FileWriter;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.game_common.EnemyGroup;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.game_common.EnemyGroupList;
import org.sehkah.ddon.tools.extractor.lib.logic.serialization.ClientResourceFileSerializer;

public class EnemyGroupSerializer extends ClientResourceFileSerializer<EnemyGroupList> {

    private static void writeEnemyGroup(EnemyGroup enemyGroup, FileWriter fileWriter) {
        fileWriter.writeUnsignedInteger(enemyGroup.EnemyGroupId());
        fileWriter.writeUnsignedInteger(enemyGroup.MsgIndex());
        fileWriter.writeArray(enemyGroup.EmList(), () -> fileWriter::writeUnsignedInteger);
    }

    @Override
    protected void serializeClientResourceFile(EnemyGroupList clientResource, FileWriter fileWriter) {
        fileWriter.writeUnsignedInteger(clientResource.getEnemyGroupList().size());
        clientResource.getEnemyGroupList().forEach(enemyGroup -> writeEnemyGroup(enemyGroup, fileWriter));
    }
}
