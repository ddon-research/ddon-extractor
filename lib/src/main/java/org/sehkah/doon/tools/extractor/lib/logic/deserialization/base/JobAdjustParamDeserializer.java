package org.sehkah.doon.tools.extractor.lib.logic.deserialization.base;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ClientResourceFile;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.FileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.base.AdjustParam;

import java.util.List;

public class JobAdjustParamDeserializer extends FileDeserializer<List<AdjustParam>> {
    public JobAdjustParamDeserializer() {
        super(ClientResourceFile.rAdjustParam);
    }

    private static AdjustParam readEntity(FileReader fileReader) {
        return new AdjustParam(fileReader.readFloat());
    }

    @Override
    protected List<AdjustParam> readObject(FileReader fileReader) {
        return fileReader.readArray(JobAdjustParamDeserializer::readEntity);
    }
}
