package org.sehkah.ddon.tools.extractor.season1.logic.resource.deserialization.season3.fieldarea;

import org.sehkah.ddon.tools.extractor.lib.common.io.BufferReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.season3.fieldarea.FieldAreaMarkerInfo;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.season3.fieldarea.MarkerInfo;

public class FieldAreaMarkerInfoDeserializer extends ClientResourceFileDeserializer {
    public FieldAreaMarkerInfoDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static MarkerInfo readMarkerInfo(BufferReader bufferReader) {
        return new MarkerInfo(
                bufferReader.readVector3f(),
                bufferReader.readSignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger()
        );
    }

    @Override
    protected FieldAreaMarkerInfo parseClientResourceFile(BufferReader bufferReader) {
        return new FieldAreaMarkerInfo(
                bufferReader.readUnsignedInteger(),
                bufferReader.readArray(FieldAreaMarkerInfoDeserializer::readMarkerInfo)
        );
    }
}
