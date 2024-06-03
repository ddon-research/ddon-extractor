package org.sehkah.ddon.tools.extractor.season3.logic.resource.deserialization.EM;

import org.sehkah.ddon.tools.extractor.lib.common.io.BufferReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.EM.BitData;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.EM.BitTable;

public class BitTableDeserializer extends ClientResourceFileDeserializer {
    public BitTableDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static BitData readBitData(BufferReader bufferReader) {
        return new BitData(
                bufferReader.readUnsignedLong(),
                bufferReader.readUnsignedInteger()
        );
    }

    @Override
    protected BitTable parseClientResourceFile(BufferReader bufferReader) {
        return new BitTable(bufferReader.readArray(BitTableDeserializer::readBitData));
    }
}
