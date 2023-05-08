package org.sehkah.doon.tools.extractor.lib.logic.deserialization.base;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ExtensionMap;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.FileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.base.StageListInfo;

public class StageListDeserializer extends FileDeserializer {
    public StageListDeserializer(FileReader fileReader) {
        super(ExtensionMap.rStageList, fileReader);
    }

    private static StageListInfo readEntity(FileReader fileReader) {
        return new StageListInfo(
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedByte(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger()
        );
    }

    @Override
    protected Object readObject() {
        return fileReader.readArray(StageListDeserializer::readEntity);
    }
}
