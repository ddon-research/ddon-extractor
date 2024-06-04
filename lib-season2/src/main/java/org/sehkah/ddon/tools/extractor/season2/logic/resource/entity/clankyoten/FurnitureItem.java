package org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.clankyoten;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.lib.common.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.DynamicResourceLookupUtil;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class FurnitureItem {
    private long ItemId;
    private long LayoutId;
    @MetaInformation
    private String LayoutName;
    private long OmId;

    public FurnitureItem(long itemId, long layoutId, long omId) {
        this(itemId,
                layoutId, DynamicResourceLookupUtil.getFurnitureLayoutName("FURNITURE_LAYOUT_NAME_" + layoutId),
                omId);
    }
}
