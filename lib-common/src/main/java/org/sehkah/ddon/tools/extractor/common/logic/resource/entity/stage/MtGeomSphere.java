package org.sehkah.ddon.tools.extractor.common.logic.resource.entity.stage;

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
public class MtGeomSphere extends MtGeomConvex {
    private Sphere Sphere;

    public MtGeomSphere(MtGeomConvex base, org.sehkah.ddon.tools.extractor.api.datatype.Sphere sphere) {
        super(base.getMargin());
        Sphere = sphere;
    }
}
