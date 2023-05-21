package org.sehkah.doon.tools.extractor.lib.logic.entity.season2.base;

import org.sehkah.doon.tools.extractor.lib.common.entity.TopLevelClientResource;

import java.util.List;

public record ItemList(
        long ArrayDataNum,
        long ArrayParamDataNum,
        long ArrayVsParamDataNum,
        long ArrayWeaponParamDataNum,
        long ArrayProtectParamDataNum,
        long ArrayEquipParamS8DataNum,
        List<ItemListItemParam> ItemParamList
) implements TopLevelClientResource {
}
