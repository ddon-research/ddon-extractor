package org.sehkah.ddon.tools.extractor.season2.logic.resource.deserialization.base;

import org.sehkah.ddon.tools.extractor.lib.common.io.BufferReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.base.AdjustParam;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.base.AdjustParamList;

public class JobAdjustParamDeserializer extends ClientResourceFileDeserializer {
    public JobAdjustParamDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static AdjustParam readAdjustParam(BufferReader bufferReader) {
        return new AdjustParam(bufferReader.readFloat());
    }

    @Override
    protected AdjustParamList parseClientResourceFile(BufferReader bufferReader) {
        return new AdjustParamList(bufferReader.readArray(JobAdjustParamDeserializer::readAdjustParam));
    }
}
