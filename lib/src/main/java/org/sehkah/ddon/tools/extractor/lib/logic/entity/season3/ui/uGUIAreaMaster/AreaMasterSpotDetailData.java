package org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.ui.uGUIAreaMaster;

import java.util.List;

public record AreaMasterSpotDetailData(
        long SpotId,
        List<SpotItemData> ItemArray,
        List<SpotEnemyData> EnemyArray

) {
}
