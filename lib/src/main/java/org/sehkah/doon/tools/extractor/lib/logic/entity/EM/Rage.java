package org.sehkah.doon.tools.extractor.lib.logic.entity.EM;

import org.sehkah.doon.tools.extractor.lib.logic.entity.EM.meta.RageMindStatusType;
import org.sehkah.doon.tools.extractor.lib.logic.serialization.MetaInformation;

public record Rage(
        long StatusStartHpPer,
        long StatusEndHpPer,
        long MindStatus,
        @MetaInformation
        RageMindStatusType MindStatusType,
        float MindStatusFrameMax
) {
    public Rage(long statusStartHpPer, long statusEndHpPer, long mindStatus, float mindStatusFrameMax) {
        this(
                statusStartHpPer,
                statusEndHpPer,
                mindStatus, RageMindStatusType.of(mindStatus),
                mindStatusFrameMax);
    }
}
