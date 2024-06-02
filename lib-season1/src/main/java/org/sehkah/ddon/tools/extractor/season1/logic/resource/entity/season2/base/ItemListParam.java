package org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.season2.base;

import lombok.extern.slf4j.Slf4j;
import org.sehkah.ddon.tools.extractor.lib.common.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.season2.base.meta.ItemListElementParamKind;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.season2.base.meta.ItemListMaterialCategory;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.season2.base.meta.ItemListParamKind;

import java.util.List;

@Slf4j
public record ItemListParam(
        short KindType,
        @MetaInformation
        String KindTypeName,
        List<Integer> Parameters // TODO typification
) {
    public ItemListParam {
        if (KindTypeName.equals("ELEMENT_PARAM_KIND_UNKNOWN") || KindTypeName.equals("PARAM_KIND_UNKNOWN")) {
            log.warn("KindType '{}' is unknown.", KindType);
        }
    }

    public ItemListParam(int category, short kindType, List<Integer> parameters) {
        this(
                kindType, getKindTypeName(category, kindType),
                parameters
        );
    }

    private static String getKindTypeName(int category, short kindType) {
        log.trace("{}, {}", category, kindType);
        if (category == (int) ItemListMaterialCategory.MATERIAL_CATEGORY_ELEMENT_WEP.value
                || category == (int) ItemListMaterialCategory.MATERIAL_CATEGORY_ELEMENT_ARMOR.value
                || category == (int) ItemListMaterialCategory.MATERIAL_CATEGORY_COLOR.value) {
            return ItemListElementParamKind.of(kindType).name();
        }
        return ItemListParamKind.of(kindType).name();
    }
}
