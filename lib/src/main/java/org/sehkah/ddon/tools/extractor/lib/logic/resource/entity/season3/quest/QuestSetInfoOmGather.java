package org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.quest;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.sehkah.ddon.tools.extractor.lib.common.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.stage.SetInfo;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.stage.meta.SetInfoOmGatherType;

@RequiredArgsConstructor
@Getter
@JsonPropertyOrder(alphabetic = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class QuestSetInfoOmGather extends SetInfo {
    private final QuestSetInfoOm InfoOm;
    private final long ItemListID;
    private final long GatheringType;
    @MetaInformation
    private final SetInfoOmGatherType GatheringTypeName;
    private final boolean IsGatherEnemy;
    private final short EnemyGroupNo;

    public QuestSetInfoOmGather(QuestSetInfoOm infoOm, long itemListID, long gatheringType, boolean isGatherEnemy, short enemyGroupNo) {
        InfoOm = infoOm;
        ItemListID = itemListID;
        GatheringType = gatheringType;
        GatheringTypeName = SetInfoOmGatherType.of(gatheringType);
        IsGatherEnemy = isGatherEnemy;
        EnemyGroupNo = enemyGroupNo;
    }
}