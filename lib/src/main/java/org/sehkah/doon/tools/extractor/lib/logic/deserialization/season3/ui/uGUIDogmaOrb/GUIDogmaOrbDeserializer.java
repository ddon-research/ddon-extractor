package org.sehkah.doon.tools.extractor.lib.logic.deserialization.season3.ui.uGUIDogmaOrb;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.ClientResourceFile;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ClientResourceFileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.season3.ui.uGUIDogmaOrb.GUIDogmaOrbRes;

import java.util.List;

public class GUIDogmaOrbDeserializer extends ClientResourceFileDeserializer<List<GUIDogmaOrbRes>> {
    public GUIDogmaOrbDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static GUIDogmaOrbRes readEntity(FileReader fileReader) {
        return new GUIDogmaOrbRes(
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger()
        );
    }

    @Override
    protected List<GUIDogmaOrbRes> parseClientResourceFile(FileReader fileReader) {
        return fileReader.readArray(GUIDogmaOrbDeserializer::readEntity);
    }
}
