package org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.stage;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.api.datatype.Sphere;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class ScenarioZoneShapeInfoSphere extends ScenarioZoneShapeInfoBase {
    private Sphere sphere;

    public ScenarioZoneShapeInfoSphere(ScenarioZoneShapeInfoBase base, Sphere sphere) {
        super(base.isIsNativeData(), base.getDecay());
        this.sphere = sphere;
    }
}
