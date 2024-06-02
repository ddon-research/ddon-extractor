package org.sehkah.ddon.tools.extractor.season1.logic.resource.deserialization.season3.EM;

import org.sehkah.ddon.tools.extractor.lib.common.io.BufferReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.season3.EM.Rage;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.season3.EM.RageTable;

public class RageTableDeserializer extends ClientResourceFileDeserializer {
    public RageTableDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static Rage readRage(BufferReader bufferReader) {
        return new Rage(
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readFloat()
        );
    }

    @Override
    protected RageTable parseClientResourceFile(BufferReader bufferReader) {
        return new RageTable(bufferReader.readArray(RageTableDeserializer::readRage));
    }
}
