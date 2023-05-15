package org.sehkah.doon.tools.extractor.lib.logic.entity.base;

import java.util.List;

public record ItemList(
        long ArrayDataNum,
        long ArrayParamDataNum,
        long ArrayVsParamDataNum,
        long ArrayWeaponParamDataNum,
        long ArrayProtectParamDataNum,
        long ArrayEquipParamS8DataNum,
        List<ItemListItemParam> ItemParamList
) {
}
