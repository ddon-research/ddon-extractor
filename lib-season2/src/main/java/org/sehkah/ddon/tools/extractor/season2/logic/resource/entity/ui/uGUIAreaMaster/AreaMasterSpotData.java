package org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.ui.uGUIAreaMaster;

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
) {
}
