package org.sehkah.doon.tools.extractor.lib.logic.entity.skill;

public record NormalSkillData(
        long NeedJp,
        int NeedLv,
        int SkillNo,
        int IconId,
        int Index,
        int MsgIndex,
        int Category,
        int PreSkillIndex,
        int SlotNo
) {
}
