package org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.base;

import org.sehkah.ddon.tools.extractor.lib.common.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ResourceFileLookupType;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.DynamicResourceLookupUtil;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.base.meta.StageInfoType;

public record StageListInfo(
        long StageNo,
        @MetaInformation
        long StageId,
        long Type,
        @MetaInformation
        StageInfoType TypeName,
        int RecommendLevel,
        long MessageId,
        @MetaInformation
        String StageName,
        long Version
) {
    public StageListInfo(long stageNo, long type, int recommendLevel, long messageId, long version) {
        this(
                stageNo, Long.parseLong(DynamicResourceLookupUtil.getMessageKey(ResourceFileLookupType.STAGE_LIST, messageId).replace("STAGE_NAME_", "")),
                type, StageInfoType.of(type),
                recommendLevel,
                messageId, DynamicResourceLookupUtil.getMessage(ResourceFileLookupType.STAGE_LIST, messageId),
                version);
    }
}
