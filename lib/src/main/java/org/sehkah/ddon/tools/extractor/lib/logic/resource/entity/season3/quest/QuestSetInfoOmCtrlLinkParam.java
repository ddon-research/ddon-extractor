package org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.quest;

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