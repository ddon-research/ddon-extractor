package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.stage;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class AreaHitShapeNativeAllocInfo {
    private long ShapeBoxArrayNum;
    private long ShapeSphereArrayNum;
    private long ShapeCylinderArrayNum;
    private long ShapeConeArrayNum;
    private long ShapeAABBArrayNum;
    private long ShapeOBBArrayNum;
}
