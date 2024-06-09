package org.sehkah.ddon.tools.extractor.common.logic.resource.entity.EM;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class EnemyLocalEst {
    private long Idx;
    private long BitNo;
    private long Status;
    private boolean CheckBit;
    private boolean PlayAlways;
    private long ControlType;
    private long ControlIndex;
    private long BitContrlCommand;
    private boolean SetUpOff;
}
