package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.stage;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.api.datatype.Cylinder;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class ZoneShapeInfoCylinder extends ZoneShapeInfoBase {
    private Cylinder Cylinder;

    public ZoneShapeInfoCylinder(ZoneShapeInfoBase base, org.sehkah.ddon.tools.extractor.api.datatype.Cylinder cylinder) {
        super(base.getDecay(), base.isIsNativeData());
        Cylinder = cylinder;
    }
}
