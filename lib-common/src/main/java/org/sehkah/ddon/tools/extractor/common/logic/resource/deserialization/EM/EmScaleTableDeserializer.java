package org.sehkah.ddon.tools.extractor.common.logic.resource.deserialization.EM;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.EM.EmScale;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.EM.EmScaleTable;

import java.nio.file.Path;

public class EmScaleTableDeserializer extends ClientResourceFileDeserializer<EmScaleTable> {


    private static EmScale readEmScaleData(BufferReader bufferReader) {
        return new EmScale(
                bufferReader.readUnsignedInteger(),
                bufferReader.readFloat(),
                bufferReader.readVector3f()
        );
    }

    @Override
    protected EmScaleTable parseClientResourceFile(Path filePath, BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new EmScaleTable(bufferReader.readArray(EmScaleTableDeserializer::readEmScaleData));
    }
}
