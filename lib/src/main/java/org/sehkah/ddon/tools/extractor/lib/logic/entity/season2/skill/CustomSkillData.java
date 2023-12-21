package org.sehkah.ddon.tools.extractor.lib.logic.entity.season2.skill;

import org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.skill.SkillLevelData;

import java.util.List;

public record CustomSkillData(
        int Id,
        int MsgNameIndex,
        int IconId,
        List<SkillLevelData> LvArray
) {
}
