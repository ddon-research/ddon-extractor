package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.quest;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.api.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.stage.meta.SetInfoOmGatherType;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.stage.SetInfo;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class QuestSetInfoOmTreasureBox extends SetInfo {
    private QuestSetInfoOm InfoOm;
    private long ItemListID;
    private long GatheringType;
    @MetaInformation
    private SetInfoOmGatherType GatheringTypeName;
    private boolean IsGatherEnemy;
    // TODO: lookup?
    private short EnemyGroupNo;

    public QuestSetInfoOmTreasureBox(QuestSetInfoOm infoOm, long itemListID, long gatheringType, boolean isGatherEnemy, short enemyGroupNo) {
        InfoOm = infoOm;
        ItemListID = itemListID;
        GatheringType = gatheringType;
        GatheringTypeName = SetInfoOmGatherType.of(gatheringType);
        IsGatherEnemy = isGatherEnemy;
        EnemyGroupNo = enemyGroupNo;
    }
}
