package org.sehkah.ddon.tools.extractor.season3.logic.resource.deserialization.fieldarea;

import org.sehkah.ddon.tools.extractor.lib.common.io.BufferReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.fieldarea.FieldAreaMarkerInfo;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.fieldarea.MarkerInfo;

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
