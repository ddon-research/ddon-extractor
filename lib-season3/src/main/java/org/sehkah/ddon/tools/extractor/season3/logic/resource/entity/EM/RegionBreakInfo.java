package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.EM;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class RegionBreakInfo {
    private int LockOffJointID;
    private int LockOnJointID;
    private int SoundJointNo;
}
