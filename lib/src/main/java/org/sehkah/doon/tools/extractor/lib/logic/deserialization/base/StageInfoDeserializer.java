package org.sehkah.doon.tools.extractor.lib.logic.deserialization.base;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ExtractionType;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.FileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.base.StageInfo;

public class StageInfoDeserializer extends FileDeserializer {
    public StageInfoDeserializer(FileReader fileReader) {
        super(ExtractionType.STAGE_INFO, fileReader);
    }

    private static StageInfo readEntity(FileReader reader) {
        return new StageInfo(
                reader.readUnsignedInteger(),
                reader.readUnsignedInteger(),
                reader.readUnsignedByte(),
                reader.readUnsignedInteger(),
                reader.readUnsignedInteger()
        );
    }

    @Override
    public Object deserialize() {
        if (!isMagicValid() || !isVersionValid()) {
            return null;
        }
        return fileReader.readArray(StageInfoDeserializer::readEntity);
    }
}
