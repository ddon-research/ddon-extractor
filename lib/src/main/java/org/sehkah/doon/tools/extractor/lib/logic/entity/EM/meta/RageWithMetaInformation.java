package org.sehkah.doon.tools.extractor.lib.logic.entity.EM.meta;

import org.sehkah.doon.tools.extractor.lib.logic.entity.EM.Rage;

public record RageWithMetaInformation(
        long StatusStartHpPer,
        long StatusEndHpPer,
        long MindStatus,
        RageMindStatusType MindStatusType,
        float MindStatusFrameMax
) {
    public RageWithMetaInformation(Rage rage) {
        this(
                rage.StatusStartHpPer(),
                rage.StatusEndHpPer(),
                rage.MindStatus(), RageMindStatusType.of(rage.MindStatus()),
                rage.MindStatusFrameMax()
        );
    }
}
