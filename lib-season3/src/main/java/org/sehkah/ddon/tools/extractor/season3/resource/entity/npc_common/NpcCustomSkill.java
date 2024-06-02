package org.sehkah.ddon.tools.extractor.season3.resource.entity.npc_common;

public record NpcCustomSkill(
        long ThinkId,
        int CustomSkill1,
        int CustomSkill2,
        int CustomSkill3,
        int CustomSkill4,
        int CustomSkillLv1,
        int CustomSkillLv2,
        int CustomSkillLv3,
        int CustomSkillLv4,
        int NormalSkillBit
) {
}
