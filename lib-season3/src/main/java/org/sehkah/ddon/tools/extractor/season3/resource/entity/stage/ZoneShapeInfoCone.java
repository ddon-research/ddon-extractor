package org.sehkah.ddon.tools.extractor.season3.resource.entity.stage;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.sehkah.ddon.tools.extractor.lib.common.datatype.Vector3f;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@RequiredArgsConstructor
@Getter
@JsonPropertyOrder(alphabetic = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class ZoneShapeInfoCone extends ZoneShapeInfoBase {
    private final float Height;
    private final float TopRadius;
    private final Vector3f Pos;
    private final float BottomRadius;

    public ZoneShapeInfoCone(ZoneShapeInfoBase base, float height, float topRadius, Vector3f pos, float bottomRadius) {
        super(base.getDecay());
        Height = height;
        TopRadius = topRadius;
        Pos = pos;
        BottomRadius = bottomRadius;
    }
}
