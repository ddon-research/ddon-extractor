package org.sehkah.doon.tools.extractor.lib.logic.entity.season3.sg300000;

import org.sehkah.doon.tools.extractor.lib.common.entity.TopLevelClientResource;

import java.util.List;

public record ShopGoodsList(
        List<ShopGoods> ShopGoodsList
) implements TopLevelClientResource {

}
