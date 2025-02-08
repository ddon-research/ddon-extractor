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
public class SetInfoOmSealedTreasureBox extends SetInfo { // 封印されし宝箱 - sealed treasure chest / box
    private boolean IsSealedByEnemyGroup;
    private int Unknown1;
    private int EnemyGroup;
    private int EnemySubGroup;
    private long ItemListID;
    private int Unknown2;
    private boolean IsGatherEnemy;
    private SetInfoOmOld InfoOm;
}
