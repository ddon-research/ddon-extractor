package org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.ui.uGUIAreaMaster;

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
