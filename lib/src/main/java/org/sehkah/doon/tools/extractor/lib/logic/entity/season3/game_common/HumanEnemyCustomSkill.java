package org.sehkah.doon.tools.extractor.lib.logic.entity.season3.game_common;

import org.sehkah.doon.tools.extractor.lib.common.entity.DeserializableClientResource;

public record HumanEnemyCustomSkill(
        long Id,
        long CustomSkill0,
        long CustomSkill1,
        long CustomSkill2,
        long CustomSkill3,
        long CustomLevel0,
        long CustomLevel1,
        long CustomLevel2,
        long CustomLevel3
) implements DeserializableClientResource {
}
