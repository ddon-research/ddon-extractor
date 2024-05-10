package org.sehkah.ddon.tools.extractor.lib.logic.deserialization.season3.effect_common;

import org.sehkah.ddon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.ddon.tools.extractor.lib.logic.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.effect_common.VfxLightInfluence;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.effect_common.VfxLightInfluenceList;

public class VfxLightInfluenceListDeserializer extends ClientResourceFileDeserializer {
    public VfxLightInfluenceListDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static VfxLightInfluence readVfxLightInfluence(FileReader fileReader) {
        return new VfxLightInfluence(
                fileReader.readFloat(),
                fileReader.readFloat(),
                fileReader.readFloat(),
                fileReader.readFloat(),
                fileReader.readFloat(),
                fileReader.readFloat(),
                fileReader.readFloat(),
                fileReader.readFloat()
        );
    }

    @Override
    protected VfxLightInfluenceList parseClientResourceFile(FileReader fileReader) {
        return new VfxLightInfluenceList(fileReader.readArray(VfxLightInfluenceListDeserializer::readVfxLightInfluence));
    }
}
