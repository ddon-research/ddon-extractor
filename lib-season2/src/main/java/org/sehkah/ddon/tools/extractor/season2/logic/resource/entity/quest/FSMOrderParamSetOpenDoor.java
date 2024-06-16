package org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.quest;


import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class FSMOrderParamSetOpenDoor extends AICopiableParameter {
    private long GroupNo;
    private long SetNo;
    private boolean IsQuestSet;
    // TODO: Lookup
    private long QuestId;
}
