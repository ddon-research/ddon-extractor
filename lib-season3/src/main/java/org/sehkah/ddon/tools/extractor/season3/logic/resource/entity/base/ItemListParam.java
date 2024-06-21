package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.base;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.sehkah.ddon.tools.extractor.api.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.base.meta.ItemListElementParamKind;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.base.meta.ItemListMaterialCategory;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.base.meta.ItemListParamKind;

import java.util.List;

@Slf4j
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class ItemListParam {
    private short KindType;
    @MetaInformation
    private String KindTypeName;
    private List<Integer> Parameters; // TODO typification;

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
