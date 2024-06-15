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
public class ScenarioZoneShapeInfoCylinder extends ScenarioZoneShapeInfoBase {
    private Cylinder cylinder;

    public ScenarioZoneShapeInfoCylinder(ScenarioZoneShapeInfoBase base, Cylinder cylinder) {
        super(base.isIsNativeData(), base.getDecay());
        this.cylinder = cylinder;
    }
}
