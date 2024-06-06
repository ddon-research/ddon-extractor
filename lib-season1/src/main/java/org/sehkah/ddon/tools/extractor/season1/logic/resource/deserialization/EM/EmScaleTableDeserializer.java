package org.sehkah.ddon.tools.extractor.season1.logic.resource.deserialization.EM;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.EM.EmScale;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.EM.EmScaleTable;

public class EmScaleTableDeserializer extends ClientResourceFileDeserializer {


    private static EmScale readEmScaleData(BufferReader bufferReader) {
        return new EmScale(
                bufferReader.readUnsignedInteger(),
                bufferReader.readFloat(),
                bufferReader.readVector3f()
        );
    }

    @Override
    protected EmScaleTable parseClientResourceFile(BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new EmScaleTable(bufferReader.readArray(EmScaleTableDeserializer::readEmScaleData));
    }
}
