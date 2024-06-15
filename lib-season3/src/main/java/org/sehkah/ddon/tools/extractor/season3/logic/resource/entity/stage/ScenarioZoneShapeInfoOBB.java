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
public class ScenarioZoneShapeInfoOBB extends ScenarioZoneShapeInfoBase {
    private boolean IsEnableExtendedDecay;
    private float DecayY;
    private float DecayZ;
    private OrientedBoundingBox OBB;

    public ScenarioZoneShapeInfoOBB(ScenarioZoneShapeInfoBase base, boolean isEnableExtendedDecay, float decayY, float decayZ, OrientedBoundingBox OBB) {
        super(base.isIsNativeData(), base.getDecay());
        IsEnableExtendedDecay = isEnableExtendedDecay;
        DecayY = decayY;
        DecayZ = decayZ;
        this.OBB = OBB;
    }
}
