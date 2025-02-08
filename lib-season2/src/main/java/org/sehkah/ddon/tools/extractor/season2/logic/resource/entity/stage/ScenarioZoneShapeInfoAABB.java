package org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.stage;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.api.datatype.AxisAlignedBoundingBox;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class ScenarioZoneShapeInfoAABB extends ScenarioZoneShapeInfoBase {
    private boolean IsEnableExtendedDecay;
    private float DecayY;
    private float DecayZ;
    private AxisAlignedBoundingBox AABB;

    public ScenarioZoneShapeInfoAABB(ScenarioZoneShapeInfoBase base, boolean isEnableExtendedDecay, float decayY, float decayZ, AxisAlignedBoundingBox AABB) {
        super(base.isIsNativeData(), base.getDecay());
        IsEnableExtendedDecay = isEnableExtendedDecay;
        DecayY = decayY;
        DecayZ = decayZ;
        this.AABB = AABB;
    }
}
