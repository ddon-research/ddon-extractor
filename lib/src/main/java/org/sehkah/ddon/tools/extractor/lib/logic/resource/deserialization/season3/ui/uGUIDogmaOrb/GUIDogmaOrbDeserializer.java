package org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.season3.ui.uGUIDogmaOrb;

import org.sehkah.ddon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.ui.uGUIDogmaOrb.GUIDogmaOrb;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.ui.uGUIDogmaOrb.GUIDogmaOrbRes;

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
