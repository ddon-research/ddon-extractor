package org.sehkah.ddon.tools.extractor.season1.logic.resource.deserialization.season3.EM;

import org.sehkah.ddon.tools.extractor.lib.common.io.BufferReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.season3.EM.EmScale;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.season3.EM.EmScaleTable;

public class EmScaleTableDeserializer extends ClientResourceFileDeserializer {
    public EmScaleTableDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static EmScale readEmScaleData(BufferReader bufferReader) {
        return new EmScale(
                bufferReader.readUnsignedInteger(),
                bufferReader.readFloat(),
                bufferReader.readVector3f()
        );
    }

    @Override
    protected EmScaleTable parseClientResourceFile(BufferReader bufferReader) {
        return new EmScaleTable(bufferReader.readArray(EmScaleTableDeserializer::readEmScaleData));
    }
}
