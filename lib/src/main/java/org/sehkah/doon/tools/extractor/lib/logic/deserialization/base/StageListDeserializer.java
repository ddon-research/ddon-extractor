package org.sehkah.doon.tools.extractor.lib.logic.deserialization.base;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ExtensionMap;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.FileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.base.StageInfo;
import org.sehkah.doon.tools.extractor.lib.logic.entity.base.meta.StageInfoWithMetaInformation;

public class StageListDeserializer extends FileDeserializer {
    public StageListDeserializer(FileReader fileReader) {
        super(ExtensionMap.rStageList, fileReader);
    }


    private static StageInfo readEntity(FileReader fileReader) {
        return new StageInfo(
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedByte(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger()
        );
    }

    private static StageInfoWithMetaInformation readEntityWithMetaInformation(FileReader fileReader) {
        return StageInfoWithMetaInformation.of(readEntity(fileReader));
    }


    @Override
    protected Object readObject() {
        return fileReader.readArray(StageListDeserializer::readEntity);
    }

    @Override
    protected Object readObjectWithMetaInformation() {
        return fileReader.readArray(StageListDeserializer::readEntityWithMetaInformation);
    }
}