package org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.stage;

import java.util.List;

public record StageConnectConnect(
        short Start,
        short Goal,
        List<Short> Index,
        long IndexNum
) {
}
