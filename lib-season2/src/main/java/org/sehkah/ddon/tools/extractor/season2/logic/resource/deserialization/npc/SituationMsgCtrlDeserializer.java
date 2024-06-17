package org.sehkah.ddon.tools.extractor.season2.logic.resource.deserialization.npc;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.Translation;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.npc.SituationData;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.npc.SituationMsgCtrl;

import java.nio.file.Path;

public class SituationMsgCtrlDeserializer extends ClientResourceFileDeserializer<SituationMsgCtrl> {
    private static SituationData readSituationData(BufferReader bufferReader, ResourceMetadataLookupUtil lookupUtil) {
        long GroupSerial = bufferReader.readUnsignedInteger();
        long StartQuestId = bufferReader.readUnsignedInteger();
        boolean IsStartQuestIdStart = bufferReader.readBoolean();
        long EndQuestId = bufferReader.readUnsignedInteger();
        boolean IsEndQuestIdStart = bufferReader.readBoolean();

        Translation StartQuestName = null;
        Translation EndQuestName = null;
        if (lookupUtil != null) {
            StartQuestName = lookupUtil.getQuestName(StartQuestId);
            EndQuestName = lookupUtil.getQuestName(EndQuestId);
        }

        return new SituationData(GroupSerial, StartQuestId, StartQuestName, IsStartQuestIdStart, EndQuestId, EndQuestName, IsEndQuestIdStart);
    }

    @Override
    protected SituationMsgCtrl parseClientResourceFile(Path filePath, BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new SituationMsgCtrl(bufferReader.readArray(SituationMsgCtrlDeserializer::readSituationData, lookupUtil));
    }
}
