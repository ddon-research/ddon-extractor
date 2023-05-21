package org.sehkah.doon.tools.extractor.lib.logic.entity.season3.sg300000.meta;

import java.util.Arrays;

public enum ShopGoodsReplenishType {
    REPLENISH_GAME_DAYS(0x0),
    REPLENISH_REAL_DATE(0x1);


    public final long value;

    ShopGoodsReplenishType(long value) {
        this.value = value;
    }

    public static ShopGoodsReplenishType of(long value) {
        return Arrays.stream(ShopGoodsReplenishType.values()).filter(shopGoodsReplenishType -> shopGoodsReplenishType.value == value).findFirst().orElse(null);
    }
}
