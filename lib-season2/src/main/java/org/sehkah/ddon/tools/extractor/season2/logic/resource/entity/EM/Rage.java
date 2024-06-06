package org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.EM;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.api.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.EM.meta.RageMindStatusType;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class Rage {
    private long StatusStartHpPer;
    private long StatusEndHpPer;
    private long MindStatus;
    @MetaInformation
    private RageMindStatusType MindStatusType;
    private float MindStatusFrameMax;

    public Rage(long statusStartHpPer, long statusEndHpPer, long mindStatus, float mindStatusFrameMax) {
        this(
                statusStartHpPer,
                statusEndHpPer,
                mindStatus, RageMindStatusType.of(mindStatus),
                mindStatusFrameMax);
    }
}
