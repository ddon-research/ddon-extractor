package org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.skill;

import java.util.List;

public record CustomSkillData(
        int Id,
        // TODO: Requires memorizing file names for looking up the appropriate GMD
        int MsgNameIndex,
        int IconId,
        List<SkillLevelData> LvArray
) {
}
