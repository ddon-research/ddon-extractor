package org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.stage;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.lib.common.datatype.AxisAlignedBoundingBox;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class ZoneShapeInfoAABB extends ZoneShapeInfoBase {
    private AxisAlignedBoundingBox AABB;
    private float DecayY;
    private float DecayZ;
    private boolean IsEnableExtendedDecay;

    public ZoneShapeInfoAABB(ZoneShapeInfoBase base, AxisAlignedBoundingBox AABB, float decayY, float decayZ, boolean isEnableExtendedDecay) {
        super(base.getDecay());
        this.AABB = AABB;
        DecayY = decayY;
        DecayZ = decayZ;
        IsEnableExtendedDecay = isEnableExtendedDecay;
    }
}
