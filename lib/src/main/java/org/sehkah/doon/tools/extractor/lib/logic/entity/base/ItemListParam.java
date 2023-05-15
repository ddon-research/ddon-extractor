package org.sehkah.doon.tools.extractor.lib.logic.entity.base;

import org.sehkah.doon.tools.extractor.lib.logic.entity.base.meta.ItemListElementParamKind;
import org.sehkah.doon.tools.extractor.lib.logic.entity.base.meta.ItemListMaterialCategory;
import org.sehkah.doon.tools.extractor.lib.logic.entity.base.meta.ItemListParamKind;
import org.sehkah.doon.tools.extractor.lib.logic.serialization.MetaInformation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;


public record ItemListParam(
        short KindType,
        @MetaInformation
        String KindTypeName,
        List<Integer> Parameters // TODO typification
) {
    private static final Logger logger = LoggerFactory.getLogger(ItemListParam.class);

    public ItemListParam {
        if (KindTypeName.equals("ELEMENT_PARAM_KIND_UNKNOWN") || KindTypeName.equals("PARAM_KIND_UNKNOWN")) {
            logger.warn("KindType '{}' is unknown.", KindType);
        }
    }

    public ItemListParam(int category, short kindType, List<Integer> parameters) {
        this(
                kindType, getKindTypeName(category, kindType),
                parameters
        );
    }

    private static String getKindTypeName(int category, short kindType) {
        logger.info("category {}", category);
        if (category == (int) ItemListMaterialCategory.MATERIAL_CATEGORY_ELEMENT_WEP.value || category == (int) ItemListMaterialCategory.MATERIAL_CATEGORY_ELEMENT_ARMOR.value) {
            return ItemListElementParamKind.of(kindType).name();
        }
        return ItemListParamKind.of(kindType).name();
    }
}
