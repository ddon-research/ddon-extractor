package org.sehkah.doon.tools.extractor.lib.logic.deserialization.season3.game_common;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.ClientResourceFile;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ClientResourceFileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.season3.game_common.ShrinkBlowValue;
import org.sehkah.doon.tools.extractor.lib.logic.entity.season3.game_common.ShrinkBlowValueList;

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
