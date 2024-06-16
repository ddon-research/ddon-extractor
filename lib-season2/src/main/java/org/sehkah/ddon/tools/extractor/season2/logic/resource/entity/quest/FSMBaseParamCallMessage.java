package org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.quest;


import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.api.logic.resource.Translation;
import org.sehkah.ddon.tools.extractor.api.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.quest.meta.ParamCallMessageType;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class FSMBaseParamCallMessage extends AICopiableParameter {
    private long MsgType;
    @MetaInformation
    private ParamCallMessageType MsgTypeName;
    private long QuestId;//QuestNo
    @MetaInformation
    private Translation QuestName;
    // TODO: Lookup
    private long MsgNo;
    private float MsgDispTime;
    private float MsgWaitTime;
    private boolean IsUseSerial;
    private boolean IsHideMessage;
}
