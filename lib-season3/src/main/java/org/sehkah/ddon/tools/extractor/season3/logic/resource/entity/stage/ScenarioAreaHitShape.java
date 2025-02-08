package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.stage;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.api.datatype.AxisAlignedBoundingBox;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class ScenarioAreaHitShape {
    private String Name;
    private float CheckAngle;
    private float CheckRange;
    private float CheckToward;
    private boolean AngleFlag;
    private boolean TowardFlag;
    private ScenarioZoneShapeInfoBase Zone;
    private AxisAlignedBoundingBox ZoneBoundingBox;
}
