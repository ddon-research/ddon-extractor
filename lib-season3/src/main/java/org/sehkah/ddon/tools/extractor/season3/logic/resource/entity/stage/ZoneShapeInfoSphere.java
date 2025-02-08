package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.stage;

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
public class ZoneShapeInfoSphere extends ZoneShapeInfoBase {
    private Sphere Sphere;

    public ZoneShapeInfoSphere(ZoneShapeInfoBase base, org.sehkah.ddon.tools.extractor.api.datatype.Sphere sphere) {
        super(base.getDecay(), base.isIsNativeData());
        Sphere = sphere;
    }
}
