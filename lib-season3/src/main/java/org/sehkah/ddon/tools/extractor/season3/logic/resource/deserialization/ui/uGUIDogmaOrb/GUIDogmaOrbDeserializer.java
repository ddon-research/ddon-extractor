package org.sehkah.ddon.tools.extractor.season3.logic.resource.deserialization.ui.uGUIDogmaOrb;

import org.sehkah.ddon.tools.extractor.lib.common.io.BufferReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.ui.uGUIDogmaOrb.GUIDogmaOrb;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.ui.uGUIDogmaOrb.GUIDogmaOrbRes;

public class GUIDogmaOrbDeserializer extends ClientResourceFileDeserializer {
    public GUIDogmaOrbDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static GUIDogmaOrbRes readGUIDogmaOrbRes(BufferReader bufferReader) {
        return new GUIDogmaOrbRes(
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger()
        );
    }

    @Override
    protected GUIDogmaOrb parseClientResourceFile(BufferReader bufferReader) {
        return new GUIDogmaOrb(bufferReader.readArray(GUIDogmaOrbDeserializer::readGUIDogmaOrbRes));
    }
}
