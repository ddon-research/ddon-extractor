package org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.season2.skill;

import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.season3.skill.SkillLevelData;

import java.util.List;

public record CustomSkillData(
        int Id,
        // TODO: Requires memorizing file names for looking up the appropriate GMD
        int MsgNameIndex,
        int IconId,
        List<SkillLevelData> LvArray
) {
}
