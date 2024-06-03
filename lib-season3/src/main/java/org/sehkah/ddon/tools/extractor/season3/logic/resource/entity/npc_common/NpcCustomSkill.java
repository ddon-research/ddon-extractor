package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.npc_common;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class NpcCustomSkill {
    private long ThinkId;
    private int CustomSkill1;
    private int CustomSkill2;
    private int CustomSkill3;
    private int CustomSkill4;
    private int CustomSkillLv1;
    private int CustomSkillLv2;
    private int CustomSkillLv3;
    private int CustomSkillLv4;
    private int NormalSkillBit;
}
