package org.sehkah.doon.tools.extractor.lib.logic.entity.game_common;

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
) {
}
