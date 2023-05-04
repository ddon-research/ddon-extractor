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
        return fileReader.readArray(StageInfoDeserializer::readEntity);
    }

    @Override
    protected Object readObjectWithMetaInformation() {
        return fileReader.readArray(StageInfoDeserializer::readEntityWithMetaInformation);
    }
}
