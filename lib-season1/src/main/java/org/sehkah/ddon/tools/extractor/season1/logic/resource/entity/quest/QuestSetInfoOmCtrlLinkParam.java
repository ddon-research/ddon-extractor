package org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.quest;

public record QuestSetInfoOmCtrlLinkParam(
        int Kind,
        int Group,
        int ID,
        long Transition,
        long State,
        int CamEvNo,
        String FSM // rAIFSM
) {

}
