package org.sehkah.ddon.tools.extractor.season1.logic.resource.deserialization.season3.game_common;

import org.sehkah.ddon.tools.extractor.lib.common.io.BufferReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.season3.game_common.ShrinkBlowValue;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.season3.game_common.ShrinkBlowValueList;

public class ShrinkBlowValueDeserializer extends ClientResourceFileDeserializer {
    public ShrinkBlowValueDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static ShrinkBlowValue readShrinkBlowValue(BufferReader bufferReader) {
        return new ShrinkBlowValue(
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readFloat(),
                bufferReader.readFloat(),
                bufferReader.readFloat(),
                bufferReader.readFloat()
        );
    }

    @Override
    protected ShrinkBlowValueList parseClientResourceFile(BufferReader bufferReader) {
        return new ShrinkBlowValueList(bufferReader.readArray(ShrinkBlowValueDeserializer::readShrinkBlowValue));
    }
}
