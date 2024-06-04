package org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.pawn;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.lib.common.datatype.Sphere;
import org.sehkah.ddon.tools.extractor.lib.common.datatype.Vector3f;

import java.util.List;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class AISensorNodeRes {
    private Sphere Sphere;
    private Vector3f Dir;
    private float EffectiveAngle;
    private List<Long> CategoryFlag;
    private int JntNo;
    private long GroupFlag;
    private long UserFlag;
    private long StatusFlag;
}
