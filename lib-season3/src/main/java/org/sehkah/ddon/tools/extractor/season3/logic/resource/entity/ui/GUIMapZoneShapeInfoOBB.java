package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.ui;

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
public class GUIMapZoneShapeInfoOBB extends GUIMapZoneShapeInfoBase {
    private OrientedBoundingBox OBB;
    private float Padding;
    private float DecayY;
    private float DecayZ;
    private boolean IsEnableExtendedDecay;

    public GUIMapZoneShapeInfoOBB(GUIMapZoneShapeInfoBase base, OrientedBoundingBox obb, float padding, float decayY, float decayZ, boolean isEnableExtendedDecay) {
        super(base.getDecay(), base.isIsNativeData());
        OBB = obb;
        Padding = padding;
        DecayY = decayY;
        DecayZ = decayZ;
        IsEnableExtendedDecay = isEnableExtendedDecay;
    }
}
