package org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.EM;

import org.sehkah.ddon.tools.extractor.lib.common.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.EM.meta.RageMindStatusType;

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
