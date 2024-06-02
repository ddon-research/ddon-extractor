package org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.ui.uGUIAreaMaster;

import java.util.List;

public record AreaMasterSpotDetailData(
        long SpotId,
        List<SpotItemData> ItemArray,
        List<SpotEnemyData> EnemyArray

) {
}
