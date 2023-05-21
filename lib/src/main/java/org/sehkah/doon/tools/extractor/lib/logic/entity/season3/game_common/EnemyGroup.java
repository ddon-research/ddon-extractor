package org.sehkah.doon.tools.extractor.lib.logic.entity.season3.game_common;

import java.util.List;

public record EnemyGroup(
        long EnemyGroupId,
        long MsgIndex,
        List<Long> EmList
) {
}
