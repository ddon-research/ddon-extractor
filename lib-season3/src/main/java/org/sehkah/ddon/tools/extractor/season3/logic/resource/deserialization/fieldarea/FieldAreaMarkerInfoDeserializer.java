package org.sehkah.ddon.tools.extractor.season3.logic.resource.deserialization.fieldarea;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.fieldarea.FieldAreaMarkerInfo;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.fieldarea.MarkerInfo;

public class FieldAreaMarkerInfoDeserializer extends ClientResourceFileDeserializer {


    private static MarkerInfo readMarkerInfo(BufferReader bufferReader) {
        return new MarkerInfo(
                bufferReader.readVector3f(),
                bufferReader.readSignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger()
        );
    }

    @Override
    protected FieldAreaMarkerInfo parseClientResourceFile(BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new FieldAreaMarkerInfo(
                bufferReader.readUnsignedInteger(),
                bufferReader.readArray(FieldAreaMarkerInfoDeserializer::readMarkerInfo)
        );
    }
}
