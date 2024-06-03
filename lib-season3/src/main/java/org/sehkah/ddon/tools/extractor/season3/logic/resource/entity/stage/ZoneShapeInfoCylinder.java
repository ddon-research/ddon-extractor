package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.stage;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.sehkah.ddon.tools.extractor.lib.common.datatype.Cylinder;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@RequiredArgsConstructor
@Getter
@JsonPropertyOrder(alphabetic = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class ZoneShapeInfoCylinder extends ZoneShapeInfoBase {
    private final Cylinder Cylinder;

    public ZoneShapeInfoCylinder(ZoneShapeInfoBase base, org.sehkah.ddon.tools.extractor.lib.common.datatype.Cylinder cylinder) {
        super(base.getDecay());
        Cylinder = cylinder;
    }
}
