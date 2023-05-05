package org.sehkah.doon.tools.extractor.lib.logic.deserialization.base;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ExtensionMap;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.FileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.base.AreaInfoStage;

public class AreaInfoStageDeserializer extends FileDeserializer {
    public AreaInfoStageDeserializer(FileReader fileReader) {
        super(ExtensionMap.rAreaInfoStage, fileReader);
    }

    private static AreaInfoStage readEntity(FileReader fileReader) {
        return new AreaInfoStage(
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger()
        );
    }

    @Override
    protected Object readObject() {
        return fileReader.readArray(AreaInfoStageDeserializer::readEntity);
    }

    @Override
    protected Object readObjectWithMetaInformation() {
        return readObject();
    }
}

