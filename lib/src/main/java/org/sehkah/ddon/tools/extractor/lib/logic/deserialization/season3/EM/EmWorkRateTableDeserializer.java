package org.sehkah.ddon.tools.extractor.lib.logic.deserialization.season3.EM;

import org.sehkah.ddon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.ddon.tools.extractor.lib.logic.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.EM.EmWorkRate;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.EM.EmWorkRateTable;

public class EmWorkRateTableDeserializer extends ClientResourceFileDeserializer {
    public EmWorkRateTableDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static EmWorkRate readEmWorkRate(FileReader fileReader) {
        return new EmWorkRate(
                fileReader.readFloat(),
                fileReader.readUnsignedInteger()
        );
    }

    @Override
    protected EmWorkRateTable parseClientResourceFile(FileReader fileReader) {
        return new EmWorkRateTable(fileReader.readArray(EmWorkRateTableDeserializer::readEmWorkRate));
    }
}
