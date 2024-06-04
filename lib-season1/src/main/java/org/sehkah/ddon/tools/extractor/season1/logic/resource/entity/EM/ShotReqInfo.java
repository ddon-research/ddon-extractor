package org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.EM;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.lib.common.datatype.Vector3f;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class ShotReqInfo {
    private long ShotGroup;
    private long ShotIndex;
    private long SetTarget;
    private long JointNo;
    private boolean IsConst;
    private Vector3f OffsetPos;
    private Vector3f OffsetDir;
    private boolean IsLockOnTarget;
}
