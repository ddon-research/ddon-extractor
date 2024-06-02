package org.sehkah.ddon.tools.extractor.season3.resource.deserialization.EM;

import org.sehkah.ddon.tools.extractor.lib.common.io.BufferReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season3.resource.entity.EM.Rage;
import org.sehkah.ddon.tools.extractor.season3.resource.entity.EM.RageTable;

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
