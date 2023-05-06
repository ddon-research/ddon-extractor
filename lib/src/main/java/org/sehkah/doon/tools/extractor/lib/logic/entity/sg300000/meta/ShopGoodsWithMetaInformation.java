package org.sehkah.doon.tools.extractor.lib.logic.entity.sg300000.meta;

import org.sehkah.doon.tools.extractor.lib.logic.entity.sg300000.ShopGoods;

import java.math.BigInteger;

public record ShopGoodsWithMetaInformation(
        int Category,
        ShopGoodsCategoryType CategoryType,
        long ID,
        BigInteger Price,
        int GoldType,
        int SaleType,
        ShopGoodsSaleType SaleTypeName,
        int RequiredFavorite,
        ShopGoodsDate StartDate,
        ShopGoodsDate EndDate,
        int StockNum,
        int MaxStockNum,
        int ReplenishRate,
        int ReplenishType,
        ShopGoodsReplenishType ReplenishTypeName,
        int InGameDays,
        ShopGoodsDate RealDate
) {
    public ShopGoodsWithMetaInformation(ShopGoods shopGoods) {
        this(
                shopGoods.Category(), ShopGoodsCategoryType.of(shopGoods.Category()),
                shopGoods.ID(),
                shopGoods.Price(),
                shopGoods.GoldType(),
                shopGoods.SaleType(), ShopGoodsSaleType.of(shopGoods.SaleType()),
                shopGoods.RequiredFavorite(),
                shopGoods.StartDate(),
                shopGoods.EndDate(),
                shopGoods.StockNum(),
                shopGoods.MaxStockNum(),
                shopGoods.ReplenishRate(),
                shopGoods.ReplenishType(), ShopGoodsReplenishType.of(shopGoods.ReplenishType()),
                shopGoods.InGameDays(),
                shopGoods.RealDate()
        );
    }
}
