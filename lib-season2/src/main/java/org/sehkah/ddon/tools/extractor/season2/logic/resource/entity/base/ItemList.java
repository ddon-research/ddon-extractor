package org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.base;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.lib.common.entity.TopLevelClientResource;

import java.util.List;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class ItemList extends TopLevelClientResource {
    private long ArrayDataNum;
    private long ArrayParamDataNum;
    private long ArrayVsParamDataNum;
    private long ArrayWeaponParamDataNum;
    private long ArrayProtectParamDataNum;
    private long ArrayEquipParamS8DataNum;
    private List<ItemListItemParam> ItemParamList;
}
