package org.sehkah.doon.tools.extractor.lib.logic.entity.base.meta;

import org.sehkah.doon.tools.extractor.lib.logic.entity.base.StageInfo;

public record StageInfoWithMetaInformation(
        long StageNo,
        long Type,
        StageInfoType TypeName,
        int RecommendLevel,
        long MessageId,
        long Version
) {
    public StageInfoWithMetaInformation(StageInfo stageInfo) {
        this(
                stageInfo.StageNo(),
                stageInfo.Type(), StageInfoType.of(stageInfo.Type()),
                stageInfo.RecommendLevel(),
                stageInfo.MessageId(),
                stageInfo.Version()
        );
    }
}
