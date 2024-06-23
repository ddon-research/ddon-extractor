package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.skill;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class SkillLevelData {
    // TODO: Lookup
    private int MsgExpIndex;
    private int NeedLv;
    private long NeedJp;
}
