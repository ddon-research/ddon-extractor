package org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.season3.sg300000.meta;

import java.util.Arrays;

public enum ShopGoodsSaleType {
    SALE_NORMAL(0x0),
    SALE_LIMITED(0x1),
    SALE_FAVORITE(0x2);


    public final long value;

    ShopGoodsSaleType(long value) {
        this.value = value;
    }

    public static ShopGoodsSaleType of(long value) {
        return Arrays.stream(ShopGoodsSaleType.values()).filter(shopGoodsSaleType -> shopGoodsSaleType.value == value).findFirst().orElse(null);
    }
}
