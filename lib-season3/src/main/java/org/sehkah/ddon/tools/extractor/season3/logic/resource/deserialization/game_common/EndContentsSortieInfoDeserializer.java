package org.sehkah.ddon.tools.extractor.season3.logic.resource.deserialization.game_common;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.Translation;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.game_common.EndContentsSortieInfoData;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.game_common.EndContentsSortieInfoTable;

import java.nio.file.Path;

public class EndContentsSortieInfoDeserializer extends ClientResourceFileDeserializer<EndContentsSortieInfoTable> {
    private static EndContentsSortieInfoData readEndContentsSortieInfoData(BufferReader bufferReader, ResourceMetadataLookupUtil lookupUtil) {
        long QuestId = bufferReader.readUnsignedInteger();
        long StageNo1 = bufferReader.readUnsignedInteger();
        long StageNo2 = bufferReader.readUnsignedInteger();
        long StageNo3 = bufferReader.readUnsignedInteger();
        long Unknown1 = bufferReader.readUnsignedInteger();
        long Unknown2 = bufferReader.readUnsignedInteger();
        long Flag = bufferReader.readUnsignedInteger();
        boolean Unknown3 = bufferReader.readBoolean();

        Translation QuestName = null;
        Translation StageName1 = null;
        Translation StageName2 = null;
        Translation StageName3 = null;
        if (lookupUtil != null) {
            QuestName = lookupUtil.getQuestName(QuestId);
            StageName1 = lookupUtil.getStageNameByStageNo((int) StageNo1);
            StageName2 = lookupUtil.getStageNameByStageNo((int) StageNo2);
            StageName3 = lookupUtil.getStageNameByStageNo((int) StageNo3);
        }

        return new EndContentsSortieInfoData(QuestId, QuestName, StageNo1, StageName1, StageNo2, StageName2, StageNo3, StageName3, Unknown1, Unknown2, Flag, Unknown3);
    }

    @Override
    protected EndContentsSortieInfoTable parseClientResourceFile(Path filePath, BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new EndContentsSortieInfoTable(bufferReader.readArray(EndContentsSortieInfoDeserializer::readEndContentsSortieInfoData, lookupUtil));
    }
}
