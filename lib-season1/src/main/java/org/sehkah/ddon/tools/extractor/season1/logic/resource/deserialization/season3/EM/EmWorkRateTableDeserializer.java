package org.sehkah.ddon.tools.extractor.season1.logic.resource.deserialization.season3.EM;

import org.sehkah.ddon.tools.extractor.lib.common.io.BufferReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.season3.EM.EmWorkRate;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.season3.EM.EmWorkRateTable;

public class EmWorkRateTableDeserializer extends ClientResourceFileDeserializer {
    public EmWorkRateTableDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static EmWorkRate readEmWorkRate(BufferReader bufferReader) {
        return new EmWorkRate(
                bufferReader.readFloat(),
                bufferReader.readUnsignedInteger()
        );
    }

    @Override
    protected EmWorkRateTable parseClientResourceFile(BufferReader bufferReader) {
        return new EmWorkRateTable(bufferReader.readArray(EmWorkRateTableDeserializer::readEmWorkRate));
    }
}
