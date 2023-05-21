package org.sehkah.doon.tools.extractor.lib.logic.deserialization.season3.base;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.ClientResourceFile;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ClientResourceFileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.season3.base.AdjustParam;

import java.util.List;

public class JobAdjustParamDeserializer extends ClientResourceFileDeserializer<List<AdjustParam>> {
    public JobAdjustParamDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static AdjustParam readEntity(FileReader fileReader) {
        return new AdjustParam(fileReader.readFloat());
    }

    @Override
    protected List<AdjustParam> parseClientResourceFile(FileReader fileReader) {
        return fileReader.readArray(JobAdjustParamDeserializer::readEntity);
    }
}
