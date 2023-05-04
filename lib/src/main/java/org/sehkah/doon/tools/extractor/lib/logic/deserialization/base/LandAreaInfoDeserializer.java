package org.sehkah.doon.tools.extractor.lib.logic.deserialization.base;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ExtractionType;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.FileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.base.LandAreaInfo;
import org.sehkah.doon.tools.extractor.lib.logic.entity.base.meta.LandAreaInfoWithMetaInformation;

public class LandAreaInfoDeserializer extends FileDeserializer {
    public LandAreaInfoDeserializer(FileReader fileReader) {
        super(ExtractionType.LAND_AREA_INFO, fileReader);
    }

    private static LandAreaInfo readEntity(FileReader reader) {
        return new LandAreaInfo(
                reader.readUnsignedInteger(),
                reader.readBoolean(),
                reader.readUnsignedByte(),
                reader.readArray(FileReader::readUnsignedInteger)
        );
    }

    private static LandAreaInfoWithMetaInformation readEntityWithMetaInformation(FileReader reader) {
        return LandAreaInfoWithMetaInformation.of(readEntity(reader));
    }

    @Override
    public Object deserialize() {
        return deserialize(false);
    }

    @Override
    public Object deserialize(boolean addMetaInformation) {
        if (!isMagicValid() || !isVersionValid()) {
            return null;
        }
        if (addMetaInformation) {
            return fileReader.readArray(LandAreaInfoDeserializer::readEntityWithMetaInformation);
        } else {
            return fileReader.readArray(LandAreaInfoDeserializer::readEntity);
        }
    }
}
