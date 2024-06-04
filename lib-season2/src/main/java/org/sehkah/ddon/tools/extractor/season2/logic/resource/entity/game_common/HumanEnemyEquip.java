package org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.game_common;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class HumanEnemyEquip {
    private long Id;
    private long MainWeaponId;
    private long SubWeaponId;
    private long WearTopId;
    private long WearBottomId;
    private long HeadId;
    private long ArmorId;
    private long HandId;
    private long LegId;
    private long AccessoryId;
    private long Jewelry;
}
