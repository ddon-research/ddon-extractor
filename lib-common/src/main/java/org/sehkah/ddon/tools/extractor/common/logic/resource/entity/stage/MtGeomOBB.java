package org.sehkah.ddon.tools.extractor.common.logic.resource.entity.stage;

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
public class MtGeomOBB extends MtGeomConvex {
    private OrientedBoundingBox OBB;

    public MtGeomOBB(MtGeomConvex base, OrientedBoundingBox OBB) {
        super(base.getMargin());
        this.OBB = OBB;
    }
}
