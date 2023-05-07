package org.sehkah.doon.tools.extractor.lib.logic.entity.base.meta;

import org.sehkah.doon.tools.extractor.lib.logic.entity.base.StageListInfo;

public record StageInfoWithMetaInformation(
        long StageNo,
        long Type,
        StageInfoType TypeName,
        int RecommendLevel,
        long MessageId,
        long Version
) {
    public StageInfoWithMetaInformation(StageListInfo stageListInfo) {
        this(
                stageListInfo.StageNo(),
                stageListInfo.Type(), StageInfoType.of(stageListInfo.Type()),
                stageListInfo.RecommendLevel(),
                stageListInfo.MessageId(),
                stageListInfo.Version()
        );
    }
}
