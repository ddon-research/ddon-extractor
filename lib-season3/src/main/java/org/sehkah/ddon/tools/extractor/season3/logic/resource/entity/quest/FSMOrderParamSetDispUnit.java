package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.quest;


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
public class FSMOrderParamSetDispUnit extends AICopiableParameter {
    private long Act;
    private long Target;
    private long GroupNo;
    private long SetId;
    private long QuestId;
    @MetaInformation
    private Translation QuestName;
    private boolean IsStopMove;
}
