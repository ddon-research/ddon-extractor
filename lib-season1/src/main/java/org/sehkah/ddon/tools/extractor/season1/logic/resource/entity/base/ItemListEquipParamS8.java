package org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.base;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.api.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.base.meta.ItemListEquipParamS8FormType;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.base.meta.ItemListEquipParamS8Kind;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class ItemListEquipParamS8 {
    private int KindType;
    @MetaInformation
    private ItemListEquipParamS8Kind KindTypeName;
    private int Form;
    @MetaInformation
    private ItemListEquipParamS8FormType FormType;
    private int Parameter;

    public ItemListEquipParamS8(int kindType, int form, int parameter) {
        this(
                kindType, ItemListEquipParamS8Kind.of(kindType),
                form, ItemListEquipParamS8FormType.of(form),
                parameter);
    }
}
