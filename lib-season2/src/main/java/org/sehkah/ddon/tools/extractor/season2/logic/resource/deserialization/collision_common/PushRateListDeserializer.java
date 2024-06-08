package org.sehkah.ddon.tools.extractor.season2.logic.resource.deserialization.collision_common;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.collision_common.PushRate;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.collision_common.PushRateList;

import java.nio.file.Path;

public class PushRateListDeserializer extends ClientResourceFileDeserializer<PushRateList> {


    private static PushRate readPushRate(BufferReader bufferReader) {
        return new PushRate(
                bufferReader.readFixedLengthArray(6, BufferReader::readFloat)
        );
    }

    @Override
    protected PushRateList parseClientResourceFile(Path filePath, BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new PushRateList(bufferReader.readArray(PushRateListDeserializer::readPushRate));
    }
}
