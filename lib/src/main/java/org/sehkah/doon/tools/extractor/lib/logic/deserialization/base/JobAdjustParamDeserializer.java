package org.sehkah.doon.tools.extractor.lib.logic.deserialization.base;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ExtensionMap;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.FileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.base.AdjustParam;

public class JobAdjustParamDeserializer extends FileDeserializer {
    public JobAdjustParamDeserializer(FileReader fileReader) {
        super(ExtensionMap.rAdjustParam, fileReader);
    }

    private static AdjustParam readEntity(FileReader fileReader) {
        return new AdjustParam(fileReader.readFloat());
    }

    @Override
    protected Object readObject() {
        return fileReader.readArray(JobAdjustParamDeserializer::readEntity);
    }

    @Override
    protected Object readObjectWithMetaInformation() {
        return readObject();
    }
}
