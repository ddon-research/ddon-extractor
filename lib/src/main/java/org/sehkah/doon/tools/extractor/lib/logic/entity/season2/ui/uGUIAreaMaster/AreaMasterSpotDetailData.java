package org.sehkah.doon.tools.extractor.lib.logic.entity.season2.ui.uGUIAreaMaster;

import org.sehkah.doon.tools.extractor.lib.common.entity.DeserializableClientResource;

import java.util.List;

public record AreaMasterSpotDetailData(
        long SpotId,
        List<SpotItemData> ItemArray,
        List<SpotEnemyData> EnemyArray

) implements DeserializableClientResource {
}
