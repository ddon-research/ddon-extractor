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
public class NormalSkillData {
    private long NeedJp;
    private int NeedLv;
    private int SkillNo;
    private int IconId;
    private int Index;
    // TODO: Requires memorizing file names for looking up the appropriate GMD
    private int MsgIndex;
    private int Category;
    private int PreSkillIndex;
    private int SlotNo;
}
