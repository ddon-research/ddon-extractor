package org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season2.stage;

import java.util.List;

public record StageConnectConnect(
        short Start,
        short Goal,
        List<Short> Index,
        long IndexNum
) {
}