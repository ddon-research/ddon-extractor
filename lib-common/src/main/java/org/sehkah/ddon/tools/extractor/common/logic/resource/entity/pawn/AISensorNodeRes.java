package org.sehkah.ddon.tools.extractor.common.logic.resource.entity.pawn;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.api.datatype.Sphere;
import org.sehkah.ddon.tools.extractor.api.datatype.Vector3f;
import org.sehkah.ddon.tools.extractor.api.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.pawn.meta.AISensorStatusFlagType;

import java.util.List;
import java.util.Set;

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
    private long GroupFlag;
    private long UserFlag;
    private long StatusFlag;
    @MetaInformation
    private Set<AISensorStatusFlagType> StatusFlagType;
    private int JntNo;
}
