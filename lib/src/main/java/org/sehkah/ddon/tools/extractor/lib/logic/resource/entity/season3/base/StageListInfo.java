package org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.base;

import org.sehkah.ddon.tools.extractor.lib.common.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.DynamicResourceLookupUtil;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ResourceFileLookupType;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.base.meta.StageInfoType;

public record StageListInfo(
        long StageNo,
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
                stageNo,
                type, StageInfoType.of(type),
                recommendLevel,
                messageId, DynamicResourceLookupUtil.getMessage(ResourceFileLookupType.STAGE_LIST, messageId),
                version);
    }
}
