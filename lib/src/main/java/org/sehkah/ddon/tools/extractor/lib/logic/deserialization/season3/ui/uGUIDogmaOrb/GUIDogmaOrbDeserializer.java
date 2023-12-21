package org.sehkah.ddon.tools.extractor.lib.logic.deserialization.season3.ui.uGUIDogmaOrb;

import org.sehkah.ddon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.ddon.tools.extractor.lib.logic.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.ui.uGUIDogmaOrb.GUIDogmaOrb;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.ui.uGUIDogmaOrb.GUIDogmaOrbRes;

public class GUIDogmaOrbDeserializer extends ClientResourceFileDeserializer {
    public GUIDogmaOrbDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static GUIDogmaOrbRes readGUIDogmaOrbRes(FileReader fileReader) {
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
    protected GUIDogmaOrb parseClientResourceFile(FileReader fileReader) {
        return new GUIDogmaOrb(fileReader.readArray(GUIDogmaOrbDeserializer::readGUIDogmaOrbRes));
    }
}
