package org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.npc_common;

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
public class NpcIsUseJobParamEx {
    private int StageNo;
    @MetaInformation
    private Translation StageName;
    private int GroupNo;
    private int UnitNo;
    private long QuestId;
    @MetaInformation
    private Translation QuestName;
}
