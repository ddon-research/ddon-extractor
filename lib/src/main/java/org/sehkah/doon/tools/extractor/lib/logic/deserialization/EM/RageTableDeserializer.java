package org.sehkah.doon.tools.extractor.lib.logic.deserialization.EM;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ClientResourceFile;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.FileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.EM.Rage;

public class RageTableDeserializer extends FileDeserializer {
    public RageTableDeserializer() {
        super(ClientResourceFile.rRageTable);
    }

    private static Rage readEntity(FileReader fileReader) {
        return new Rage(
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readFloat()
        );
    }

    @Override
    protected Object readObject(FileReader fileReader) {
        return fileReader.readArray(RageTableDeserializer::readEntity);
    }
}
