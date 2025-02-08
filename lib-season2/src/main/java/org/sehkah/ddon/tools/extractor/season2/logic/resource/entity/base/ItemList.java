package org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.base;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.api.entity.Resource;

import java.util.List;
import java.util.Optional;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class ItemList extends Resource {
    private long ArrayDataNum;
    private long ArrayParamDataNum;
    private long ArrayVsParamDataNum;
    private long ArrayWeaponParamDataNum;
    private long ArrayProtectParamDataNum;
    private long ArrayEquipParamS8DataNum;
    private List<ItemListItemParam> ItemParamList;

    public ItemListItemParam getItemById(long itemId) {
        return getItemByIdNaive(itemId);
    }

    private ItemListItemParam getItemByIdNaive(long itemId) {
        Optional<ItemListItemParam> optionalIndex = ItemParamList.stream().filter(i -> i.getItemId() == itemId).findFirst();
        return optionalIndex.orElse(null);
    }
}
