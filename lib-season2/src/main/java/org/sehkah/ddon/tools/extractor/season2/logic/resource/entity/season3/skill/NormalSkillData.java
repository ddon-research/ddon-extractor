package org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.season3.skill;

public record NormalSkillData(
        long NeedJp,
        int NeedLv,
        int SkillNo,
        int IconId,
        int Index,
        // TODO: Requires memorizing file names for looking up the appropriate GMD
        int MsgIndex,
        int Category,
        int PreSkillIndex,
        int SlotNo
) {
}
