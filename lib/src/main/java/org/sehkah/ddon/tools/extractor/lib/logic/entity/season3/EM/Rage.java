package org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.EM;

import org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.EM.meta.RageMindStatusType;
import org.sehkah.ddon.tools.extractor.lib.logic.serialization.MetaInformation;

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
