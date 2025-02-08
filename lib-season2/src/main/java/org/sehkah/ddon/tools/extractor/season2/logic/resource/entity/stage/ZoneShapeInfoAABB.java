package org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.stage;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.api.datatype.AxisAlignedBoundingBox;
import org.sehkah.ddon.tools.extractor.api.datatype.Vector2f;

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
    private Vector2f Vector;
    private boolean IsEnableExtendedDecay;

    public ZoneShapeInfoAABB(ZoneShapeInfoBase base, AxisAlignedBoundingBox AABB, float decayY, float decayZ, Vector2f vector, boolean isEnableExtendedDecay) {
        super(base.getDecay(), base.isIsNativeData());
        this.AABB = AABB;
        DecayY = decayY;
        DecayZ = decayZ;
        Vector = vector;
        IsEnableExtendedDecay = isEnableExtendedDecay;
    }
}
