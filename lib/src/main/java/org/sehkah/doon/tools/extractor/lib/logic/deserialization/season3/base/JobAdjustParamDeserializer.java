package org.sehkah.doon.tools.extractor.lib.logic.deserialization.season3.base;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.ClientResourceFile;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ClientResourceFileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.season3.base.AdjustParam;
import org.sehkah.doon.tools.extractor.lib.logic.entity.season3.base.AdjustParamList;

public class JobAdjustParamDeserializer extends ClientResourceFileDeserializer {
    public JobAdjustParamDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static AdjustParam readAdjustParam(FileReader fileReader) {
        return new AdjustParam(fileReader.readFloat());
    }

    @Override
    protected AdjustParamList parseClientResourceFile(FileReader fileReader) {
        return new AdjustParamList(fileReader.readArray(JobAdjustParamDeserializer::readAdjustParam));
    }
}
