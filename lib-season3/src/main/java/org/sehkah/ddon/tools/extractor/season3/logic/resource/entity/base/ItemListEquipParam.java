package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.base;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.api.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.base.meta.ItemListEquipParamFormType;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.base.meta.ItemListEquipParamKind;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class ItemListEquipParam {
    private int KindType;
    @MetaInformation
    private ItemListEquipParamKind KindTypeName;
    private int Form;
    @MetaInformation
    private ItemListEquipParamFormType FormType;
    private int Parameter;

    public ItemListEquipParam(int kindType, int form, int parameter) {
        this(
                kindType, ItemListEquipParamKind.of(kindType),
                form, ItemListEquipParamFormType.of(form),
                parameter);
    }
}
