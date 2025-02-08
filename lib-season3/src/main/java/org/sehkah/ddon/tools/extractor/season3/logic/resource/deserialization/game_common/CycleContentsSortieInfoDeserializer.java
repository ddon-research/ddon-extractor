package org.sehkah.ddon.tools.extractor.season3.logic.resource.deserialization.game_common;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.Translation;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.game_common.CycleContentsSortieInfoData;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.game_common.CycleContentsSortieInfoTable;

import java.nio.file.Path;

public class CycleContentsSortieInfoDeserializer extends ClientResourceFileDeserializer<CycleContentsSortieInfoTable> {
    private static CycleContentsSortieInfoData readCycleContentsSortieInfoData(BufferReader bufferReader, ResourceMetadataLookupUtil lookupUtil) {
        long CycleNo = bufferReader.readUnsignedInteger();
        long CycleSubNo = bufferReader.readUnsignedInteger();
        long StageNo1 = bufferReader.readUnsignedInteger();
        long StageNo2 = bufferReader.readUnsignedInteger();
        long StageNo3 = bufferReader.readUnsignedInteger();
        boolean Unknown = bufferReader.readBoolean();

        Translation StageName1 = null;
        Translation StageName2 = null;
        Translation StageName3 = null;
        if (lookupUtil != null) {
            StageName1 = lookupUtil.getStageNameByStageNo((int) StageNo1);
            StageName2 = lookupUtil.getStageNameByStageNo((int) StageNo2);
            StageName3 = lookupUtil.getStageNameByStageNo((int) StageNo3);
        }

        return new CycleContentsSortieInfoData(CycleNo, CycleSubNo, StageNo1, StageName1, StageNo2, StageName2, StageNo3, StageName3, Unknown);
    }

    @Override
    protected CycleContentsSortieInfoTable parseClientResourceFile(Path filePath, BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new CycleContentsSortieInfoTable(bufferReader.readArray(CycleContentsSortieInfoDeserializer::readCycleContentsSortieInfoData, lookupUtil));
    }
}
