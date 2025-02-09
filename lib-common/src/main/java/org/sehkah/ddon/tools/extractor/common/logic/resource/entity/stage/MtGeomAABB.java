package org.sehkah.ddon.tools.extractor.common.logic.resource.entity.stage;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.api.datatype.AxisAlignedBoundingBox;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class MtGeomAABB extends MtGeomConvex {
    private AxisAlignedBoundingBox AABB;

    public MtGeomAABB(MtGeomConvex base, AxisAlignedBoundingBox AABB) {
        super(base.getMargin());
        this.AABB = AABB;
    }
}
