package org.sehkah.ddon.tools.extractor.common.logic.resource.entity.sound;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.api.datatype.Vector3f;
import org.sehkah.ddon.tools.extractor.api.logic.resource.Translation;
import org.sehkah.ddon.tools.extractor.api.serialization.MetaInformation;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class TargetCursorOffset {
    private long EmId;
    @MetaInformation
    private Translation EnemyName;
    private int JointNo;
    private Vector3f OffsetFromJoint;
}
