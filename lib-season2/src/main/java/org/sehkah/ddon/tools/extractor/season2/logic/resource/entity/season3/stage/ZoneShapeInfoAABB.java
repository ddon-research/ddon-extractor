package org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.season3.stage;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.sehkah.ddon.tools.extractor.lib.common.datatype.AxisAlignedBoundingBox;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@RequiredArgsConstructor
@Getter
@JsonPropertyOrder(alphabetic = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class ZoneShapeInfoAABB extends ZoneShapeInfoBase {
    private final AxisAlignedBoundingBox AABB;
    private final float DecayY;
    private final float DecayZ;
    private final boolean IsEnableExtendedDecay;

    public ZoneShapeInfoAABB(ZoneShapeInfoBase base, AxisAlignedBoundingBox AABB, float decayY, float decayZ, boolean isEnableExtendedDecay) {
        super(base.getDecay());
        this.AABB = AABB;
        DecayY = decayY;
        DecayZ = decayZ;
        IsEnableExtendedDecay = isEnableExtendedDecay;
    }
}
