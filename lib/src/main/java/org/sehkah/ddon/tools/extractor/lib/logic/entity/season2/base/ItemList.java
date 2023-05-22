package org.sehkah.ddon.tools.extractor.lib.logic.entity.season2.base;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.sehkah.ddon.tools.extractor.lib.common.entity.TopLevelClientResource;

import java.util.List;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@RequiredArgsConstructor
@Getter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public final class ItemList extends TopLevelClientResource {
    private final long ArrayDataNum;
    private final long ArrayParamDataNum;
    private final long ArrayVsParamDataNum;
    private final long ArrayWeaponParamDataNum;
    private final long ArrayProtectParamDataNum;
    private final long ArrayEquipParamS8DataNum;
    private final List<ItemListItemParam> ItemParamList;
}
