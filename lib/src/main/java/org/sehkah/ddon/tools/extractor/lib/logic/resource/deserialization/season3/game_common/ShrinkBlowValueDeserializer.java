package org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.season3.game_common;

import org.sehkah.ddon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.game_common.ShrinkBlowValue;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.game_common.ShrinkBlowValueList;

public class ShrinkBlowValueDeserializer extends ClientResourceFileDeserializer {
    public ShrinkBlowValueDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static ShrinkBlowValue readShrinkBlowValue(FileReader fileReader) {
        return new ShrinkBlowValue(
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readFloat(),
                fileReader.readFloat(),
                fileReader.readFloat(),
                fileReader.readFloat()
        );
    }

    @Override
    protected ShrinkBlowValueList parseClientResourceFile(FileReader fileReader) {
        return new ShrinkBlowValueList(fileReader.readArray(ShrinkBlowValueDeserializer::readShrinkBlowValue));
    }
}
