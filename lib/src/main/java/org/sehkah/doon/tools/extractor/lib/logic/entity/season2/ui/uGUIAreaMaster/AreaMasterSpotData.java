package org.sehkah.doon.tools.extractor.lib.logic.entity.season2.ui.uGUIAreaMaster;

import org.sehkah.doon.tools.extractor.lib.common.entity.DeserializableClientResource;

public record AreaMasterSpotData(
        long SpotId,
        long CategoryNo,
        long MessageId,
        int StageNoMap,
        float PosX,
        float PosY,
        float PosZ,
        int ImageId,
        int RecommendLevel,
        int KeyType,
        int MaskType,
        boolean PosHide
) implements DeserializableClientResource {
}
