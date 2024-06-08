package org.sehkah.ddon.tools.extractor.season2.logic.resource.deserialization.fieldarea;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.GUIMessageLookupTable;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.fieldarea.AdjoinInfo;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.fieldarea.AdjoinInfoVector3;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.fieldarea.FieldAreaAdjoinList;

import java.util.List;

public class FieldAreaAdjoinListDeserializer extends ClientResourceFileDeserializer<FieldAreaAdjoinList> {
    private static AdjoinInfoVector3 readAdjoinInfoVector3(BufferReader bufferReader) {
        return new AdjoinInfoVector3(
                bufferReader.readVector3f(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger()
        );
    }

    private static AdjoinInfo readAdjoinInfo(BufferReader bufferReader) {
        return new AdjoinInfo(
                bufferReader.readSignedShort(),
                bufferReader.readSignedShort(),
                bufferReader.readArray(FieldAreaAdjoinListDeserializer::readAdjoinInfoVector3),
                bufferReader.readUnsignedByte()
        );
    }

    @Override
    protected FieldAreaAdjoinList parseClientResourceFile(BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        short FieldAreaId = bufferReader.readSignedShort();
        String FieldAreaName = null;
        if (lookupUtil != null) {
            FieldAreaName = lookupUtil.getMessage(GUIMessageLookupTable.FIELD_AREA_NAME.getFilePath(), FieldAreaId - 1L);
        }
        List<AdjoinInfo> Array = bufferReader.readArray(FieldAreaAdjoinListDeserializer::readAdjoinInfo);

        return new FieldAreaAdjoinList(FieldAreaId, FieldAreaName, Array);
    }
}
