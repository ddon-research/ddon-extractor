package org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.sg300000;

import org.sehkah.ddon.tools.extractor.lib.common.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.sg300000.meta.ShopGoodsCategoryType;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.sg300000.meta.ShopGoodsReplenishType;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.sg300000.meta.ShopGoodsSaleType;

import java.math.BigInteger;

public record ShopGoods(
        int Category,
        @MetaInformation
        ShopGoodsCategoryType CategoryType,
        long ID,
        BigInteger Price,
        int GoldType,
        int SaleType,
        @MetaInformation
        ShopGoodsSaleType SaleTypeName,
        int RequiredFavorite,
        ShopGoodsDate StartDate,
        ShopGoodsDate EndDate,
        int StockNum,
        int MaxStockNum,
        int ReplenishRate,
        int ReplenishType,
        @MetaInformation
        ShopGoodsReplenishType ReplenishTypeName,
        int InGameDays,
        ShopGoodsDate RealDate
) {
    public ShopGoods(int category, long ID, BigInteger price, int goldType, int saleType, int requiredFavorite, ShopGoodsDate startDate, ShopGoodsDate endDate, int stockNum, int maxStockNum, int replenishRate, int replenishType, int inGameDays, ShopGoodsDate realDate) {
        this(
                category, ShopGoodsCategoryType.of(category),
                ID,
                price,
                goldType,
                saleType, ShopGoodsSaleType.of(saleType),
                requiredFavorite,
                startDate,
                endDate,
                stockNum,
                maxStockNum,
                replenishRate,
                replenishType, ShopGoodsReplenishType.of(replenishType),
                inGameDays,
                realDate);
    }
}
