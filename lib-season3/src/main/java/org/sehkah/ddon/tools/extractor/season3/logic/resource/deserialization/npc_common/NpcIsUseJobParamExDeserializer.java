package org.sehkah.ddon.tools.extractor.season3.logic.resource.deserialization.npc_common;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.Translation;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.npc_common.NpcIsUseJobParamEx;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.npc_common.NpcIsUseJobParamExList;

import java.nio.file.Path;

public class NpcIsUseJobParamExDeserializer extends ClientResourceFileDeserializer<NpcIsUseJobParamExList> {


    private static NpcIsUseJobParamEx readNpcIsUseJobParamEx(BufferReader bufferReader, ResourceMetadataLookupUtil lookupUtil) {
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

        return new NpcIsUseJobParamEx(StageNo, StageName, GroupNo, UnitNo, QuestId, QuestName);
    }

    @Override
    protected NpcIsUseJobParamExList parseClientResourceFile(Path filePath, BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new NpcIsUseJobParamExList(bufferReader.readArray(NpcIsUseJobParamExDeserializer::readNpcIsUseJobParamEx, lookupUtil));
    }
}
