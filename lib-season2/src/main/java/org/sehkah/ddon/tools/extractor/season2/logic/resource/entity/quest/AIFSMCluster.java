package org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.quest;

import java.util.List;

public record AIFSMCluster(
        long Id,
        long OwnerNodeUniqueId,
        long InitialStateId,
        List<AIFSMNode> NodeList
) {
}
