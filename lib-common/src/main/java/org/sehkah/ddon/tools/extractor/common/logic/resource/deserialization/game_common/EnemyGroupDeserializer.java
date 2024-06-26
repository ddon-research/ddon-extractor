package org.sehkah.ddon.tools.extractor.common.logic.resource.deserialization.game_common;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.GUIMessageLookupTable;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.Translation;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.game_common.EnemyGroup;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.game_common.EnemyGroupList;

import java.nio.file.Path;
import java.util.List;

public class EnemyGroupDeserializer extends ClientResourceFileDeserializer<EnemyGroupList> {
    private static EnemyGroup readEnemyGroup(BufferReader bufferReader, ResourceMetadataLookupUtil lookupUtil) {
        long EnemyGroupId = bufferReader.readUnsignedInteger();
        long MsgIndex = bufferReader.readUnsignedInteger();
        Translation EnemyGroupName = null;
        if (lookupUtil != null) {
            EnemyGroupName = lookupUtil.getMessageTranslation(GUIMessageLookupTable.ENEMY_NAME.getFilePath(), (int) MsgIndex);
        }
        List<Long> EmList = bufferReader.readArray(BufferReader::readUnsignedInteger);

        return new EnemyGroup(EnemyGroupId, MsgIndex, EnemyGroupName, EmList);
    }

    @Override
    protected EnemyGroupList parseClientResourceFile(Path filePath, BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new EnemyGroupList(bufferReader.readArray(EnemyGroupDeserializer::readEnemyGroup, lookupUtil));
    }
}
