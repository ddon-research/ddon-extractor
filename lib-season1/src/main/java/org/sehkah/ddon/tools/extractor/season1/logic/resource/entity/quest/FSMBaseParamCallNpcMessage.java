package org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.quest;


import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class FSMBaseParamCallNpcMessage extends AICopiableParameter {
    private long Type;
    // TODO: Lookup
    private long QuestId;
    // TODO: Lookup
    private long MsgNo;
}
