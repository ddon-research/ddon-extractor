package org.sehkah.doon.tools.extractor.lib.logic.entity.season3.skill;

import org.sehkah.doon.tools.extractor.lib.common.entity.DeserializableClientResource;

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
) implements DeserializableClientResource {
}
