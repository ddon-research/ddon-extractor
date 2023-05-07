package org.sehkah.doon.tools.extractor.lib.logic.entity.game_common;

public record JobMasterCtrl(
        long JobId,
        long StartJobLevel,
        long FirstTalkGrpSerial,
        long TraningTalkGrpSerial,
        long FirstOrderTalkGrpSerial,
        long JobTutorialQuestId,
        long JobMasterTutorialQuestId,
        long AreaId,
        long AreaRank
) {
}
