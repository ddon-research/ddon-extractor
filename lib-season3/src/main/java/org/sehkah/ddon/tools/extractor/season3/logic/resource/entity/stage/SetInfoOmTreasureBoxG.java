package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.stage;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;

/**
 * Sealed treasure boxes exist in BBM or in MSQ.
 * Unlocked either by defeating an enemy group or by performing a mission chain.
 */
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class SetInfoOmTreasureBoxG extends SetInfo { // 封印されし宝箱 - sealed treasure chest / box
    private boolean Block;//IsSealedByEnemyGroup
    // TODO: Lookup
    private int Kind;
    private int Grp;
    private int ID;
    private long ItemListID;
    // TODO: Lookup
    private long GatheringType;
    private boolean IsGatherEnemy;
    private SetInfoOmOld InfoOm;
}
