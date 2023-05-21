package org.sehkah.doon.tools.extractor.lib.logic.entity.season2.base;

import org.sehkah.doon.tools.extractor.lib.common.error.TechnicalException;
import org.sehkah.doon.tools.extractor.lib.logic.entity.season2.base.meta.ItemListEquipParamS8FormType;
import org.sehkah.doon.tools.extractor.lib.logic.entity.season2.base.meta.ItemListEquipParamS8Kind;
import org.sehkah.doon.tools.extractor.lib.logic.serialization.MetaInformation;

public record ItemListEquipParamS8(
        int KindType,
        @MetaInformation
        ItemListEquipParamS8Kind KindTypeName,
        int Form,
        @MetaInformation
        ItemListEquipParamS8FormType FormType,
        int Parameter
) {

    public ItemListEquipParamS8 {
        if (KindTypeName == ItemListEquipParamS8Kind.KIND_TYPE_UNKNOWN) {
            throw new TechnicalException("KindType is unknown: " + KindType);
        }
        if (FormType == ItemListEquipParamS8FormType.FORM_TYPE_UNKNOWN) {
            throw new TechnicalException("Form is unknown: " + KindType);
        }
    }

    public ItemListEquipParamS8(int kindType, int form, int parameter) {
        this(
                kindType, ItemListEquipParamS8Kind.of(kindType),
                form, ItemListEquipParamS8FormType.of(form),
                parameter);
    }
}
