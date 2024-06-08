package org.sehkah.ddon.tools.extractor.season2.logic.resource.deserialization.fieldarea;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.GUIMessageLookupTable;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.fieldarea.FieldAreaMarkerInfo;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.fieldarea.MarkerInfo;

import java.nio.file.Path;
import java.util.List;

public class FieldAreaMarkerInfoDeserializer extends ClientResourceFileDeserializer<FieldAreaMarkerInfo> {
    private static MarkerInfo readMarkerInfo(BufferReader bufferReader) {
        return new MarkerInfo(
                bufferReader.readVector3f(),
                bufferReader.readSignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger()
        );
    }

    @Override
    protected FieldAreaMarkerInfo parseClientResourceFile(Path filePath, BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        long FieldAreaId = bufferReader.readUnsignedInteger();
        String FieldAreaName = lookupUtil.getMessage(GUIMessageLookupTable.FIELD_AREA_NAME.getFilePath(), FieldAreaId - 1);
        List<MarkerInfo> MarkerInfoArray = bufferReader.readArray(FieldAreaMarkerInfoDeserializer::readMarkerInfo);

        return new FieldAreaMarkerInfo(FieldAreaId, FieldAreaName, MarkerInfoArray);
    }
}
