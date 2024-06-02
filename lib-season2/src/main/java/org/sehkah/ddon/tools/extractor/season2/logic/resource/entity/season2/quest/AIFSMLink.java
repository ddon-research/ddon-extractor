package org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.season2.quest;

public record AIFSMLink(
        String Name,
        long DestinationNodeId,
        boolean ExistCondition,
        long ConditionId
) {
}
