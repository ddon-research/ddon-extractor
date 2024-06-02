package org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.base;

import org.sehkah.ddon.tools.extractor.lib.common.error.TechnicalException;
import org.sehkah.ddon.tools.extractor.lib.common.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.base.meta.ItemListEmPhylogenyKind;

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
