package org.sehkah.doon.tools.extractor.lib.logic.entity.season3.skill;

import org.sehkah.doon.tools.extractor.lib.common.entity.DeserializableClientResource;

import java.util.List;

public record CustomSkillData(
        int Id,
        int MsgNameIndex,
        int IconId,
        int ExSkillCustomSkillIdReference,
        int ExSkillUnknownByte,
        List<SkillLevelData> LvArray
) implements DeserializableClientResource {
}
