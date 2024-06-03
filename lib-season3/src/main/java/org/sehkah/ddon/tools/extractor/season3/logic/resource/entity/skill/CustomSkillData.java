package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.skill;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;

import java.util.List;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class CustomSkillData {
    private int Id;
    private int MsgNameIndex;
    private int IconId;
    private int ExSkillCustomSkillIdReference;
    private int ExSkillUnknownByte;
    private List<SkillLevelData> LvArray;
}
