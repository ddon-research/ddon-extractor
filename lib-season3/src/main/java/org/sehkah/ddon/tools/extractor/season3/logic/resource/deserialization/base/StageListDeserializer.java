package org.sehkah.ddon.tools.extractor.season3.logic.resource.deserialization.base;


import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.GUIMessageLookupTable;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.base.StageListInfo;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.base.StageListInfoList;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.base.meta.StageInfoType;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class StageListDeserializer extends ClientResourceFileDeserializer<StageListInfoList> {
    private static StageListInfo readStageListInfo(BufferReader bufferReader, ResourceMetadataLookupUtil lookupUtil) {
        long StageNo = bufferReader.readUnsignedInteger();
        long Type = bufferReader.readUnsignedInteger();
        StageInfoType TypeName = StageInfoType.of(Type);
        int RecommendLevel = bufferReader.readUnsignedByte();
        long MessageId = bufferReader.readUnsignedInteger();
        long StageId = Long.MIN_VALUE;
        String StageName = null;
        if (lookupUtil != null) {
            StageId = Long.parseLong(lookupUtil.getMessageKey(GUIMessageLookupTable.STAGE_LIST.getFilePath(), MessageId).replace("STAGE_NAME_", ""));
            StageName = lookupUtil.getMessage(GUIMessageLookupTable.STAGE_LIST.getFilePath(), MessageId);
        }
        long Version = bufferReader.readUnsignedInteger();

        return new StageListInfo(StageNo, StageId, Type, TypeName, RecommendLevel, MessageId, StageName, Version);
    }

    @Override
    protected StageListInfoList parseClientResourceFile(Path filePath, BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        long stageListInfoSize = bufferReader.readUnsignedInteger();
        List<StageListInfo> stageListInfo = new ArrayList<>((int) stageListInfoSize);
        for (long i = 0; i < stageListInfoSize; i++) {
            stageListInfo.add(readStageListInfo(bufferReader, lookupUtil));
        }
        return new StageListInfoList(
                stageListInfoSize,
                stageListInfo
        );
    }
}
