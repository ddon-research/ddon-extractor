package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.ui;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class GUIMapAreaHitShape {
    private String Name;
    private float CheckAngle;
    private float CheckRange;
    private float CheckToward;
    private boolean AngleFlag;
    private boolean TowardFlag;
    private int ShapeType;
    private GUIMapZoneShapeInfoBase Zone;
}
