package org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.quest;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class QuestSetInfoOmCtrlLinkParam {
    private int Kind;
    private int Group;
    private int ID;
    private long Transition;
    private long State;
    private int CamEvNo;
    private String FSM; // rAIFSM;
}
