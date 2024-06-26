package org.sehkah.ddon.tools.extractor.common.logic.resource.deserialization.base;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.base.AdjustParam;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.base.AdjustParamList;

import java.nio.file.Path;

public class JobAdjustParamDeserializer extends ClientResourceFileDeserializer<AdjustParamList> {
    private static AdjustParam readAdjustParam(BufferReader bufferReader) {
        return new AdjustParam(bufferReader.readFloat());
    }

    @Override
    protected AdjustParamList parseClientResourceFile(Path filePath, BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new AdjustParamList(bufferReader.readArray(JobAdjustParamDeserializer::readAdjustParam));
    }
}
