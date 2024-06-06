package org.sehkah.ddon.tools.extractor.season2.logic.resource.deserialization.base;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.base.StageListInfo;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.base.StageListInfoList;

import java.util.ArrayList;
import java.util.List;

public class StageListDeserializer extends ClientResourceFileDeserializer {


    private static StageListInfo readStageListInfo(BufferReader bufferReader) {
        return new StageListInfo(
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedByte(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger()
        );
    }

    @Override
    protected StageListInfoList parseClientResourceFile(BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        long stageListInfoSize = bufferReader.readUnsignedInteger();
        List<StageListInfo> stageListInfo = new ArrayList<>((int) stageListInfoSize);
        for (long i = 0; i < stageListInfoSize; i++) {
            stageListInfo.add(readStageListInfo(bufferReader));
        }
        return new StageListInfoList(
                stageListInfoSize,
                stageListInfo
        );
    }
}
