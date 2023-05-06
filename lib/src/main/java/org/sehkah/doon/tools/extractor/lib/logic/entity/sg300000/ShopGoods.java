package org.sehkah.doon.tools.extractor.lib.logic.entity.sg300000;

import org.sehkah.doon.tools.extractor.lib.logic.entity.sg300000.meta.ShopGoodsDate;

import java.math.BigInteger;

public record ShopGoods(
        int Category,
        long ID,
        BigInteger Price,
        int GoldType,
        int SaleType,
        int RequiredFavorite,
        ShopGoodsDate StartDate,
        ShopGoodsDate EndDate,
        int StockNum,
        int MaxStockNum,
        int ReplenishRate,
        int ReplenishType,
        int InGameDays,
        ShopGoodsDate RealDate
) {
}
