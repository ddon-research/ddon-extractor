package org.sehkah.ddon.tools.extractor.season3.logic.resource.deserialization.fieldarea;

import org.sehkah.ddon.tools.extractor.api.datatype.Vector3f;
import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.GUIMessageLookupTable;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.Translation;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.fieldarea.FieldAreaMarkerInfo;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.fieldarea.MarkerInfo;

import java.nio.file.Path;
import java.util.List;

public class FieldAreaMarkerInfoDeserializer extends ClientResourceFileDeserializer<FieldAreaMarkerInfo> {
    private static MarkerInfo readMarkerInfo(BufferReader bufferReader, ResourceMetadataLookupUtil lookupUtil) {
        Vector3f Pos = bufferReader.readVector3f();
        int StageNo = bufferReader.readSignedInteger();
        long GroupNo = bufferReader.readUnsignedInteger();
        long UniqueId = bufferReader.readUnsignedInteger();

        Translation StageName = null;
        if (lookupUtil != null) {
            StageName = lookupUtil.getStageNameByStageNo(StageNo);
        }

        return new MarkerInfo(Pos, StageNo, StageName, GroupNo, UniqueId);
    }

    @Override
    protected FieldAreaMarkerInfo parseClientResourceFile(Path filePath, BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        long FieldAreaId = bufferReader.readUnsignedInteger();
        Translation FieldAreaName = null;
        if (lookupUtil != null) {
            FieldAreaName = lookupUtil.getMessageTranslation(GUIMessageLookupTable.FIELD_AREA_NAME.getFilePath(), (int) (FieldAreaId - 1));
        }
        List<MarkerInfo> MarkerInfoArray = bufferReader.readArray(FieldAreaMarkerInfoDeserializer::readMarkerInfo, lookupUtil);

        return new FieldAreaMarkerInfo(FieldAreaId, FieldAreaName, MarkerInfoArray);
    }
}
