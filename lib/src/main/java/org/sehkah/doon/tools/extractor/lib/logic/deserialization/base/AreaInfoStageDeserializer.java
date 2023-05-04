package org.sehkah.doon.tools.extractor.lib.logic.deserialization.base;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ExtractionType;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.FileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.base.AreaInfoStage;

public class AreaInfoStageDeserializer extends FileDeserializer {
    public AreaInfoStageDeserializer(FileReader fileReader) {
        super(ExtractionType.AREA_INFO_STAGE, fileReader);
    }

    private static AreaInfoStage readEntity(FileReader reader) {
        return new AreaInfoStage(
                reader.readUnsignedInteger(),
                reader.readUnsignedInteger()
        );
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
            return fileReader.readArray(AreaInfoStageDeserializer::readEntity);
        } else {
            return fileReader.readArray(AreaInfoStageDeserializer::readEntity);
        }
    }
}
