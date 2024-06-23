package org.sehkah.ddon.tools.extractor.common.logic.resource.entity.skill;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.api.logic.resource.Translation;
import org.sehkah.ddon.tools.extractor.api.serialization.MetaInformation;

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
    private int MsgIndex;
    @MetaInformation
    private Translation SkillName;
    @MetaInformation
    private Translation SkillInfo;
    @MetaInformation
    private Translation SkillCommand;
    // TODO: Lookup
    private int Category;
    private int PreSkillIndex;
    private int SlotNo;
}
