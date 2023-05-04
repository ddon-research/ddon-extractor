package org.sehkah.doon.tools.extractor.lib.logic.deserialization.base;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ExtractionType;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.FileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.base.LandInfo;

public class LandInfoDeserializer extends FileDeserializer {
    public LandInfoDeserializer(FileReader fileReader) {
        super(ExtractionType.LAND_INFO, fileReader);
    }

    private static LandInfo readEntity(FileReader reader) {
        return new LandInfo(
                reader.readUnsignedInteger(),
                reader.readBoolean(),
                reader.readUnsignedByte(),
                reader.readArray(FileReader::readUnsignedInteger)
        );
    }

    @Override
    public Object deserialize() {
        if (!isMagicValid() || !isVersionValid()) {
            return null;
        }
        return fileReader.readArray(LandInfoDeserializer::readEntity);
    }
}
