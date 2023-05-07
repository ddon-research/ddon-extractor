package org.sehkah.doon.tools.extractor.lib.logic.entity.skill;

import java.util.List;

public record CustomSkillData(
        int Id,
        int MsgNameIndex,
        int IconId,
        int ExSkillCustomSkillIdReference,
        int ExSkillUnknownByte,
        List<SkillLevelData> LvArray
) {
}
