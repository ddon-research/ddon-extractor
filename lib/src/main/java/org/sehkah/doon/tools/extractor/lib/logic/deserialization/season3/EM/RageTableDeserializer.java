package org.sehkah.doon.tools.extractor.lib.logic.deserialization.season3.EM;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.ClientResourceFile;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ClientResourceFileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.season3.EM.Rage;

import java.util.List;

public class RageTableDeserializer extends ClientResourceFileDeserializer<List<Rage>> {
    public RageTableDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
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
    protected List<Rage> parseClientResourceFile(FileReader fileReader) {
        return fileReader.readArray(RageTableDeserializer::readEntity);
    }
}
