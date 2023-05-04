package org.sehkah.doon.tools.extractor.lib.logic.deserialization.base;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ExtractionType;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.FileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.base.AreaInfo;

public class AreaInfoDeserializer extends FileDeserializer {
    public AreaInfoDeserializer(FileReader fileReader) {
        super(ExtractionType.AREA_INFO, fileReader);
    }

    private static AreaInfo readEntity(FileReader fileReader) {
        return new AreaInfo(
                fileReader.readUnsignedInteger(),
                fileReader.readSignedInteger(),
                fileReader.readSignedInteger()
        );
    }

    @Override
    protected Object readObject() {
        return fileReader.readArray(AreaInfoDeserializer::readEntity);
    }

    @Override
    protected Object readObjectWithMetaInformation() {
        return readObject();
    }
}
