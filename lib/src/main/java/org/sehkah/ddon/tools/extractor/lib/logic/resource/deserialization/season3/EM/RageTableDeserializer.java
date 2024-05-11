package org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.season3.EM;

import org.sehkah.ddon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.EM.Rage;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.EM.RageTable;

public class RageTableDeserializer extends ClientResourceFileDeserializer {
    public RageTableDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static Rage readRage(FileReader fileReader) {
        return new Rage(
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readFloat()
        );
    }

    @Override
    protected RageTable parseClientResourceFile(FileReader fileReader) {
        return new RageTable(fileReader.readArray(RageTableDeserializer::readRage));
    }
}
