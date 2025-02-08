package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.stage;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.api.datatype.OrientedBoundingBox;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class ZoneShapeInfoOBB extends ZoneShapeInfoBase {
    private OrientedBoundingBox OBB;
    private float DecayY;
    private float DecayZ;
    private boolean IsEnableExtendedDecay;

    public ZoneShapeInfoOBB(ZoneShapeInfoBase base, OrientedBoundingBox OBB, float decayY, float decayZ, boolean isEnableExtendedDecay) {
        super(base.getDecay(), base.isIsNativeData());
        this.OBB = OBB;
        DecayY = decayY;
        DecayZ = decayZ;
        IsEnableExtendedDecay = isEnableExtendedDecay;
    }
}
