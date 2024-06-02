package org.sehkah.ddon.tools.extractor.season3.resource.entity.game_common;

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
