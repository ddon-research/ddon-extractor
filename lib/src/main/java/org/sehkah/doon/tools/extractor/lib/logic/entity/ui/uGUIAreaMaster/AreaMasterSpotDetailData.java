package org.sehkah.doon.tools.extractor.lib.logic.entity.ui.uGUIAreaMaster;

import java.util.List;

public record AreaMasterSpotDetailData(
        long SpotId,
        List<SpotItemData> ItemArray,
        List<SpotEnemyData> EnemyArray

) {
}
