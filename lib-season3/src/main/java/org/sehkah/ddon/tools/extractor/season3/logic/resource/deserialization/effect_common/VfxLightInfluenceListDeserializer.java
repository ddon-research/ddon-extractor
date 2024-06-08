package org.sehkah.ddon.tools.extractor.season3.logic.resource.deserialization.effect_common;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.effect_common.VfxLightInfluence;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.effect_common.VfxLightInfluenceList;

import java.nio.file.Path;

public class VfxLightInfluenceListDeserializer extends ClientResourceFileDeserializer<VfxLightInfluenceList> {


    private static VfxLightInfluence readVfxLightInfluence(BufferReader bufferReader) {
        return new VfxLightInfluence(
                bufferReader.readFloat(),
                bufferReader.readFloat(),
                bufferReader.readFloat(),
                bufferReader.readFloat(),
                bufferReader.readFloat(),
                bufferReader.readFloat(),
                bufferReader.readFloat(),
                bufferReader.readFloat()
        );
    }

    @Override
    protected VfxLightInfluenceList parseClientResourceFile(Path filePath, BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new VfxLightInfluenceList(bufferReader.readArray(VfxLightInfluenceListDeserializer::readVfxLightInfluence));
    }
}
