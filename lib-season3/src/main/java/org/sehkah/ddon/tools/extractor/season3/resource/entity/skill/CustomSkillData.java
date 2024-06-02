package org.sehkah.ddon.tools.extractor.season3.resource.entity.skill;

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
