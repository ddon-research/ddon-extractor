package org.sehkah.ddon.tools.extractor.season3.logic.resource.deserialization.base;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.base.AreaInfo;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.base.AreaInfoList;

import java.util.List;

public class AreaInfoDeserializer extends ClientResourceFileDeserializer {


    private static AreaInfo readAreaInfo(BufferReader bufferReader) {
        return new AreaInfo(
                bufferReader.readUnsignedInteger(),
                bufferReader.readSignedInteger(),
                bufferReader.readSignedInteger()
        );
    }

    @Override
    protected AreaInfoList parseClientResourceFile(BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        List<AreaInfo> areaInfos = bufferReader.readArray(AreaInfoDeserializer::readAreaInfo);

        return new AreaInfoList(areaInfos);
    }
}
