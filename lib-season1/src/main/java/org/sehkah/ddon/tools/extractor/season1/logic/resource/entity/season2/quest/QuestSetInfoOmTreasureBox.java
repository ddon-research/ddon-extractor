package org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.season2.quest;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.sehkah.ddon.tools.extractor.lib.common.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.season2.stage.SetInfo;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.season2.stage.meta.SetInfoOmGatherType;

@RequiredArgsConstructor
@Getter
@JsonPropertyOrder(alphabetic = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class QuestSetInfoOmTreasureBox extends SetInfo {
    private final QuestSetInfoOm InfoOm;
    private final long ItemListID;
    private final long GatheringType;
    @MetaInformation
    private final SetInfoOmGatherType GatheringTypeName;
    private final boolean IsGatherEnemy;
    private final short EnemyGroupNo;

    public QuestSetInfoOmTreasureBox(QuestSetInfoOm infoOm, long itemListID, long gatheringType, boolean isGatherEnemy, short enemyGroupNo) {
        InfoOm = infoOm;
        ItemListID = itemListID;
        GatheringType = gatheringType;
        GatheringTypeName = SetInfoOmGatherType.of(gatheringType);
        IsGatherEnemy = isGatherEnemy;
        EnemyGroupNo = enemyGroupNo;
    }
}
