package org.sehkah.ddon.tools.extractor.model.game_common;

import java.util.List;
import java.util.Objects;

public record EnemyGroup(long enemyGroupId, long msgIndex, List<Long> emList) {
    public EnemyGroup {
        Objects.requireNonNull(emList);
    }
}
