package org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.quest;

public record AIFSMLink(
        String Name,
        long DestinationNodeId,
        boolean ExistCondition,
        long ConditionId
) {
}
