package org.sehkah.ddon.tools.extractor.season2.logic.resource.deserialization.npc_common;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.Translation;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.npc_common.NpcIsNoSetPS3;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.npc_common.NpcIsNoSetPS3Tbl;

import java.nio.file.Path;

public class NpcIsNoSetPS3TblDeserializer extends ClientResourceFileDeserializer<NpcIsNoSetPS3Tbl> {
    private static NpcIsNoSetPS3 readNpcConstItem(BufferReader bufferReader, ResourceMetadataLookupUtil lookupUtil) {
        int StageNo = bufferReader.readUnsignedShort();
        int GroupNo = bufferReader.readUnsignedShort();
        int UnitNo = bufferReader.readUnsignedByte();
        long QuestId = bufferReader.readUnsignedInteger();
        Translation StageName = null;
        Translation QuestName = null;
        if (lookupUtil != null) {
            StageName = lookupUtil.getStageNameByStageNo(StageNo);
            QuestName = lookupUtil.getQuestName(QuestId);
        }

        return new NpcIsNoSetPS3(StageNo, StageName, GroupNo, UnitNo, QuestId, QuestName);
    }

    @Override
    protected NpcIsNoSetPS3Tbl parseClientResourceFile(Path filePath, BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new NpcIsNoSetPS3Tbl(bufferReader.readArray(NpcIsNoSetPS3TblDeserializer::readNpcConstItem, lookupUtil));
    }
}
