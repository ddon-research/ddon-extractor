package org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.season2.quest;

import java.util.List;

public record AIFSMNode(
        String Name,
        long Id,
        long UniqueId,
        long OwnerId,
        AIFSMCluster SubCluster,
        long LinkListNum,
        List<AIFSMLink> LinkList,
        long ProcessListNum,
        List<AIFSMNodeProcess> ProcessList,
        AIFSMNodeUIPos UIPos,
        int ColorType,
        long Setting,
        long UserAttribute,
        boolean ExistConditionTrainsitionFromAll,
        long ConditionTrainsitionFromAllId
) {
}
