package org.sehkah.doon.tools.extractor.lib.logic.entity.season3.game_common;

import org.sehkah.doon.tools.extractor.lib.common.entity.DeserializableClientResource;

public record HumanEnemyEquip(
        long Id,
        long MainWeaponId,
        long SubWeaponId,
        long WearTopId,
        long WearBottomId,
        long HeadId,
        long ArmorId,
        long HandId,
        long LegId,
        long AccessoryId,
        long Jewelry
) implements DeserializableClientResource {
}
