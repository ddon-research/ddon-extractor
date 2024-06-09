package org.sehkah.ddon.tools.extractor.common.logic.resource.entity.shop.meta;

import java.util.Arrays;

public enum ShopGoodsCategoryType {
    CATEGORY_ITEM(0x0),
    CATEGORY_WEAPON(0x1),
    CATEGORY_ARMOR(0x2),
    CATEGORY_ELEMENT(0x3),
    CATEGORY_JOB(0x4);


    public final long value;

    ShopGoodsCategoryType(long value) {
        this.value = value;
    }

    public static ShopGoodsCategoryType of(long value) {
        return Arrays.stream(ShopGoodsCategoryType.values()).filter(shopGoodsCategoryType -> shopGoodsCategoryType.value == value).findFirst().orElse(null);
    }
}
