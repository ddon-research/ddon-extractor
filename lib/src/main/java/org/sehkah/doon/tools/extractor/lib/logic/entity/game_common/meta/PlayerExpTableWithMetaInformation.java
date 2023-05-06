package org.sehkah.doon.tools.extractor.lib.logic.entity.game_common.meta;

import org.sehkah.doon.tools.extractor.lib.logic.entity.game_common.PlayerExpTable;

public record PlayerExpTableWithMetaInformation(
        int Level,
        PlayerExpTable playerExpTable
) {
}
