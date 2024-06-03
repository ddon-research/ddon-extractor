package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.game_common;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class PrologueHmStatus {
    private int Job;
    private int Lv;
    private int Atk;
    private int Def;
    private int MAtk;
    private int MDef;
    private int CustomSkillId1;
    private int CustomSkillId2;
    private int CustomSkillId3;
    private int CustomSkillId4;
    private int CustomSkillId1Lv;
    private int CustomSkillId2Lv;
    private int CustomSkillId3Lv;
    private int CustomSkillId4Lv;
    private int NormalSkillId1;
    private int NormalSkillId2;
    private int NormalSkillId3;
}
