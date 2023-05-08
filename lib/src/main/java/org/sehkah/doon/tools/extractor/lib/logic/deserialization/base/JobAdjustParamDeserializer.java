package org.sehkah.doon.tools.extractor.lib.logic.deserialization.base;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ClientResourceFile;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.FileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.base.AdjustParam;

public class JobAdjustParamDeserializer extends FileDeserializer {
    public JobAdjustParamDeserializer() {
        super(ClientResourceFile.rAdjustParam);
    }

    private static AdjustParam readEntity(FileReader fileReader) {
        return new AdjustParam(fileReader.readFloat());
    }

    @Override
    protected Object readObject(FileReader fileReader) {
        return fileReader.readArray(JobAdjustParamDeserializer::readEntity);
    }
}
