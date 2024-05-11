package org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.season3.EM;

import org.sehkah.ddon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.EM.BitData;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.EM.BitTable;

public class BitTableDeserializer extends ClientResourceFileDeserializer {
    public BitTableDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static BitData readBitData(FileReader fileReader) {
        return new BitData(
                fileReader.readUnsignedLong(),
                fileReader.readUnsignedInteger()
        );
    }

    @Override
    protected BitTable parseClientResourceFile(FileReader fileReader) {
        return new BitTable(fileReader.readArray(BitTableDeserializer::readBitData));
    }
}
