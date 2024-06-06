package org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.base;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.api.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.base.meta.ItemListEmPhylogenyKind;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class ItemListVsEnemyParam {
    private int KindType;
    @MetaInformation
    private ItemListEmPhylogenyKind KindTypeName;
    private int Param;

    public ItemListVsEnemyParam(int kindType, int parameter) {
        this(
                kindType, ItemListEmPhylogenyKind.of(kindType),
                parameter
        );
    }
}
