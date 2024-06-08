package org.sehkah.ddon.tools.extractor.season2.logic.resource.deserialization.ui.uGUIDogmaOrb;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.ui.uGUIDogmaOrb.GUIDogmaOrb;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.ui.uGUIDogmaOrb.GUIDogmaOrbRes;

public class GUIDogmaOrbDeserializer extends ClientResourceFileDeserializer<GUIDogmaOrb> {


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
    protected GUIDogmaOrb parseClientResourceFile(BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new GUIDogmaOrb(bufferReader.readArray(GUIDogmaOrbDeserializer::readGUIDogmaOrbRes));
    }
}
