package org.sehkah.doon.tools.extractor.lib.logic.entity.base;

import org.sehkah.doon.tools.extractor.lib.common.error.TechnicalException;
import org.sehkah.doon.tools.extractor.lib.logic.entity.base.meta.ItemListEmPhylogenyKind;
import org.sehkah.doon.tools.extractor.lib.logic.serialization.MetaInformation;

public record ItemListVsEnemyParam(
        int KindType,
        @MetaInformation
        ItemListEmPhylogenyKind KindTypeName,
        int Param
) {
    public ItemListVsEnemyParam {
        if (KindTypeName == ItemListEmPhylogenyKind.EM_PHYLOGENY_KIND_UNKNOWN) {
            throw new TechnicalException("KindType is unknown: " + KindType);
        }
    }

    public ItemListVsEnemyParam(int kindType, int parameter) {
        this(
                kindType, ItemListEmPhylogenyKind.of(kindType),
                parameter
        );
    }
}
