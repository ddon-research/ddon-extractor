package org.sehkah.doon.tools.extractor.lib.logic.entity.season2.game_common;

import org.sehkah.doon.tools.extractor.lib.common.entity.TopLevelClientResource;

import java.util.List;

public record PlayerExpTableList(
        List<PlayerExpTable> PlayerExpTableList
) implements TopLevelClientResource {
}
