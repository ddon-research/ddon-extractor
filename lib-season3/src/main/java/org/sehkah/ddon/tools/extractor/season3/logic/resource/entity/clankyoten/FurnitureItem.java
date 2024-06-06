package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.clankyoten;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.api.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.ResourceMetadataLookupUtilSeason3;

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
                layoutId, ResourceMetadataLookupUtilSeason3.getFurnitureLayoutName("FURNITURE_LAYOUT_NAME_" + layoutId),
                omId);
    }
}
