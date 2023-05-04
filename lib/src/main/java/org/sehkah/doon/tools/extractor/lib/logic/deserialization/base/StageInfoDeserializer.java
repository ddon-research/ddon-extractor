package org.sehkah.doon.tools.extractor.lib.logic.deserialization.base;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ExtractionType;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.FileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.base.StageInfo;
import org.sehkah.doon.tools.extractor.lib.logic.entity.base.meta.StageInfoWithMetaInformation;

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

    private static StageInfoWithMetaInformation readEntityWithMetaInformation(FileReader reader) {
        return StageInfoWithMetaInformation.of(readEntity(reader));
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
            return fileReader.readArray(StageInfoDeserializer::readEntityWithMetaInformation);
        } else {
            return fileReader.readArray(StageInfoDeserializer::readEntity);
        }
    }
}
