package org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.skill;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.api.logic.resource.Translation;
import org.sehkah.ddon.tools.extractor.api.serialization.MetaInformation;

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
    @MetaInformation
    private Translation SkillName;
    @MetaInformation
    private Translation SkillInfo;
    @MetaInformation
    private Translation SkillCommand;
    private int IconId;
    private List<SkillLevelData> LvArray;
}
