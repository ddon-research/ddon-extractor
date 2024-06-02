package org.sehkah.ddon.tools.extractor.season3.resource.deserialization.season3.effect_common;

import org.sehkah.ddon.tools.extractor.lib.common.io.BufferReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season3.resource.entity.effect_common.VfxLightInfluence;
import org.sehkah.ddon.tools.extractor.season3.resource.entity.effect_common.VfxLightInfluenceList;

public class VfxLightInfluenceListDeserializer extends ClientResourceFileDeserializer {
    public VfxLightInfluenceListDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

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
    protected VfxLightInfluenceList parseClientResourceFile(BufferReader bufferReader) {
        return new VfxLightInfluenceList(bufferReader.readArray(VfxLightInfluenceListDeserializer::readVfxLightInfluence));
    }
}
