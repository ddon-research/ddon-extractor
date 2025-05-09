package org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.stage;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.api.datatype.Vector3f;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class ZoneShapeInfoCone extends ZoneShapeInfoBase {
    private float Height;
    private float TopRadius;
    private Vector3f Pos;
    private float BottomRadius;

    public ZoneShapeInfoCone(ZoneShapeInfoBase base, float height, float topRadius, Vector3f pos, float bottomRadius) {
        super(base.getDecay(), base.isIsNativeData());
        Height = height;
        TopRadius = topRadius;
        Pos = pos;
        BottomRadius = bottomRadius;
    }
}
