package org.sehkah.doon.tools.extractor.lib.logic.deserialization.ui.uGUIDogmaOrb;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ClientResourceFile;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.FileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.ui.uGUIDogmaOrb.GUIDogmaOrbRes;

import java.util.List;

public class GUIDogmaOrbDeserializer extends FileDeserializer<List<GUIDogmaOrbRes>> {
    public GUIDogmaOrbDeserializer() {
        super(ClientResourceFile.rGUIDogmaOrb);
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
    protected List<GUIDogmaOrbRes> readObject(FileReader fileReader) {
        return fileReader.readArray(GUIDogmaOrbDeserializer::readEntity);
    }
}
