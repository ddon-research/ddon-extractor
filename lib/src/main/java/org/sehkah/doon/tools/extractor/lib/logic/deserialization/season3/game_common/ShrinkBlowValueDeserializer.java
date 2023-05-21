package org.sehkah.doon.tools.extractor.lib.logic.deserialization.season3.game_common;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.ClientResourceFile;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ClientResourceFileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.season3.game_common.ShrinkBlowValue;

import java.util.List;

public class ShrinkBlowValueDeserializer extends ClientResourceFileDeserializer<List<ShrinkBlowValue>> {
    public ShrinkBlowValueDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static ShrinkBlowValue readEntity(FileReader fileReader) {
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
    protected List<ShrinkBlowValue> parseClientResourceFile(FileReader fileReader) {
        return fileReader.readArray(ShrinkBlowValueDeserializer::readEntity);
    }
}
