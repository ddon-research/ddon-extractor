package org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.season3.skill;

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
