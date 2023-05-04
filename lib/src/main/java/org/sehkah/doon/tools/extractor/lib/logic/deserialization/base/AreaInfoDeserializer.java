package org.sehkah.doon.tools.extractor.lib.logic.deserialization.base;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ExtractionType;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.FileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.base.AreaInfo;

public class AreaInfoDeserializer extends FileDeserializer {
    public AreaInfoDeserializer(FileReader fileReader) {
        super(ExtractionType.AREA_INFO, fileReader);
    }

    private static AreaInfo readEntity(FileReader reader) {
        return new AreaInfo(
                reader.readUnsignedInteger(),
                reader.readSignedInteger(),
                reader.readSignedInteger()
        );
    }

    @Override
    public Object deserialize() {
        if (!isMagicValid() || !isVersionValid()) {
            return null;
        }
        return fileReader.readArray(AreaInfoDeserializer::readEntity);
    }
}
