package org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.quest;


import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;

import java.util.List;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class FSMOrderParamCallEvent extends AICopiableParameter {
    // TODO: Lookup
    private int StageNo;
    // TODO: Lookup
    private int EventNo;
    private List<FSMOrderParamCallEventNpcId> NpcArray;
}
