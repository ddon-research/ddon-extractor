package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.stage;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.sehkah.ddon.tools.extractor.lib.common.datatype.OrientedBoundingBox;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@RequiredArgsConstructor
@Getter
@JsonPropertyOrder(alphabetic = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class ZoneShapeInfoOBB extends ZoneShapeInfoBase {
    private final OrientedBoundingBox OBB;
    private final float DecayY;
    private final float DecayZ;
    private final boolean IsEnableExtendedDecay;

    public ZoneShapeInfoOBB(ZoneShapeInfoBase base, OrientedBoundingBox OBB, float decayY, float decayZ, boolean isEnableExtendedDecay) {
        super(base.getDecay());
        this.OBB = OBB;
        DecayY = decayY;
        DecayZ = decayZ;
        IsEnableExtendedDecay = isEnableExtendedDecay;
    }
}
