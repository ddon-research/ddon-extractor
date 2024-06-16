package org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.quest;


import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.api.logic.resource.Translation;
import org.sehkah.ddon.tools.extractor.api.serialization.MetaInformation;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class FSMOrderParamSetLayout extends AICopiableParameter {
    private int ActType;
    private int StageNo;
    @MetaInformation
    private Translation StageName;
    private int FlagNo;
}
