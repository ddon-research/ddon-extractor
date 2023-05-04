package org.sehkah.doon.tools.extractor.lib.logic.entity.base;

public record StageInfo(
        long StageNo,
        long Type,
        int RecommendLevel,
        long MessageId,
        long Version
) {
}
