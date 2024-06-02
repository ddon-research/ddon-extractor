package org.sehkah.ddon.tools.extractor.season3.resource.entity.clankyoten;

import org.sehkah.ddon.tools.extractor.lib.common.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.season3.resource.DynamicResourceLookupUtil;

public record FurnitureItem(
        long ItemId,
        long LayoutId,
        @MetaInformation
        String LayoutName,
        long OmId
) {
    public FurnitureItem(long itemId, long layoutId, long omId) {
        this(itemId,
                layoutId, DynamicResourceLookupUtil.getFurnitureLayoutName("FURNITURE_LAYOUT_NAME_" + layoutId),
                omId);
    }
}
