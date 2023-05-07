package org.sehkah.doon.tools.extractor.lib.logic.entity.ui.uGUIAreaMaster;

public record AreaMasterSpotData(
        long SpotId,
        long CategoryNo,
        long MessageId,
        int StageNoMap,
        long QuestId,
        float PosX,
        float PosY,
        float PosZ,
        int ImageId,
        int UnknownByte,
        int RecommendLevel,
        int KeyType,
        int MaskType,
        boolean PosHide
) {
}
