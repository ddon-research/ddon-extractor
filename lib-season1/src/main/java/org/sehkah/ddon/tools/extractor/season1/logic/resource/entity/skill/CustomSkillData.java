package org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.skill;

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
    // TODO: Requires memorizing file names for looking up the appropriate GMD
    private int MsgNameIndex;
    private int IconId;
    private List<SkillLevelData> LvArray;
}
