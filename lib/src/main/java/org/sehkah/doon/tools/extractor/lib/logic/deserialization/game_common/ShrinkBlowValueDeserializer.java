package org.sehkah.doon.tools.extractor.lib.logic.deserialization.game_common;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ClientResourceFile;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.FileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.game_common.ShrinkBlowValue;

import java.util.List;

public class ShrinkBlowValueDeserializer extends FileDeserializer<List<ShrinkBlowValue>> {
    public ShrinkBlowValueDeserializer() {
        super(ClientResourceFile.rShrinkBlowValue);
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
    protected List<ShrinkBlowValue> readObject(FileReader fileReader) {
        return fileReader.readArray(ShrinkBlowValueDeserializer::readEntity);
    }
}
