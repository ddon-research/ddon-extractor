package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.sg300000;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.lib.common.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.sg300000.meta.ShopGoodsCategoryType;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.sg300000.meta.ShopGoodsReplenishType;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.sg300000.meta.ShopGoodsSaleType;

import java.math.BigInteger;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class ShopGoods {
    private int Category;
    @MetaInformation
    private ShopGoodsCategoryType CategoryType;
    private long ID;
    private BigInteger Price;
    private int GoldType;
    private int SaleType;
    @MetaInformation
    private ShopGoodsSaleType SaleTypeName;
    private int RequiredFavorite;
    private ShopGoodsDate StartDate;
    private ShopGoodsDate EndDate;
    private int StockNum;
    private int MaxStockNum;
    private int ReplenishRate;
    private int ReplenishType;
    @MetaInformation
    private ShopGoodsReplenishType ReplenishTypeName;
    private int InGameDays;
    private ShopGoodsDate RealDate;

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
