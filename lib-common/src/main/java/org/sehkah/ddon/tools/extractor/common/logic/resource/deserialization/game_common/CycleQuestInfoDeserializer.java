package org.sehkah.ddon.tools.extractor.common.logic.resource.deserialization.game_common;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.Translation;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.game_common.CycleQuestInfo;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.game_common.CycleQuestInfoList;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.game_common.CycleQuestSituationInfo;

import java.nio.file.Path;
import java.util.List;

public class CycleQuestInfoDeserializer extends ClientResourceFileDeserializer<CycleQuestInfoList> {
    private static CycleQuestSituationInfo readCycleQuestSituationInfo(BufferReader bufferReader) {
        return new CycleQuestSituationInfo(
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger()
        );
    }

    private static CycleQuestInfo readCycleQuestInfo(BufferReader bufferReader, ResourceMetadataLookupUtil lookupUtil) {
        long CycleNo = bufferReader.readUnsignedInteger();
        long CycleSubNo = bufferReader.readUnsignedInteger();
        long ContentNameIdx = bufferReader.readUnsignedInteger();
        long ContentInfoIdx = bufferReader.readUnsignedInteger();
        long GatherInfoIdx = bufferReader.readUnsignedInteger();
        List<CycleQuestSituationInfo> SituationInfo = bufferReader.readArray(CycleQuestInfoDeserializer::readCycleQuestSituationInfo);
        long GatherNpcId = bufferReader.readUnsignedInteger();
        Translation GatherNpcName = null;
        if (lookupUtil != null) {
            GatherNpcName = lookupUtil.getNpcName(GatherNpcId);
        }
        long GatherStageNo = bufferReader.readUnsignedInteger();
        long GatherStartPos = bufferReader.readUnsignedInteger();

        return new CycleQuestInfo(CycleNo, CycleSubNo, ContentNameIdx, ContentInfoIdx, GatherInfoIdx, SituationInfo, GatherNpcId, GatherNpcName, GatherStageNo, GatherStartPos);
    }

    @Override
    protected CycleQuestInfoList parseClientResourceFile(Path filePath, BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new CycleQuestInfoList(bufferReader.readArray(CycleQuestInfoDeserializer::readCycleQuestInfo, lookupUtil));
    }
}
