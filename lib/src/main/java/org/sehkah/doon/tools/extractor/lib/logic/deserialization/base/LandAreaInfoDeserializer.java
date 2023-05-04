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

    private static LandAreaInfo readEntity(FileReader fileReader) {
        return new LandAreaInfo(
                fileReader.readUnsignedInteger(),
                fileReader.readBoolean(),
                fileReader.readUnsignedByte(),
                fileReader.readArray(FileReader::readUnsignedInteger)
        );
    }

    private static LandAreaInfoWithMetaInformation readEntityWithMetaInformation(FileReader fileReader) {
        return LandAreaInfoWithMetaInformation.of(readEntity(fileReader));
    }

    @Override
    protected Object readObject() {
        return fileReader.readArray(LandAreaInfoDeserializer::readEntity);
    }

    @Override
    protected Object readObjectWithMetaInformation() {
        return fileReader.readArray(LandAreaInfoDeserializer::readEntityWithMetaInformation);
    }
}
