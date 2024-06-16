package org.sehkah.ddon.tools.extractor.season3.logic.resource.deserialization.game_common;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.GUIMessageLookupTable;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.Translation;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.game_common.FieldAreaInfo;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.game_common.FieldAreaList;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.game_common.StageNo;

import java.nio.file.Path;
import java.util.List;

public class FieldAreaListDeserializer extends ClientResourceFileDeserializer<FieldAreaList> {
    private static StageNo readStageNo(BufferReader bufferReader, ResourceMetadataLookupUtil lookupUtil) {
        int StageNo = bufferReader.readSignedInteger();
        Translation StageName = null;
        if (lookupUtil != null) {
            StageName = lookupUtil.getStageNameByStageNo(StageNo);
        }

        return new StageNo(StageNo, StageName);
    }

    private static FieldAreaInfo readFieldAreaInfo(BufferReader bufferReader, ResourceMetadataLookupUtil lookupUtil) {
        long FieldAreaId = bufferReader.readUnsignedInteger();
        long GmdIdx = bufferReader.readUnsignedInteger();
        Translation FieldAreaName = null;
        if (lookupUtil != null) {
            FieldAreaName = lookupUtil.getMessageTranslation(GUIMessageLookupTable.FIELD_AREA_NAME.getFilePath(), (int) GmdIdx);
        }
        int LandId = bufferReader.readUnsignedShort();
        int AreaId = bufferReader.readUnsignedShort();
        List<StageNo> StageNoList = bufferReader.readArray(FieldAreaListDeserializer::readStageNo, lookupUtil);
        List<StageNo> BelongStageNoList = bufferReader.readArray(FieldAreaListDeserializer::readStageNo, lookupUtil);

        return new FieldAreaInfo(FieldAreaId, GmdIdx, FieldAreaName, LandId, AreaId, StageNoList, BelongStageNoList);
    }

    @Override
    protected FieldAreaList parseClientResourceFile(Path filePath, BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new FieldAreaList(bufferReader.readArray(FieldAreaListDeserializer::readFieldAreaInfo, lookupUtil));
    }
}
