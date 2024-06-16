package org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.quest;


import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.api.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.quest.meta.ParamCallMessageType;

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
    // TODO: Lookup
    private long QuestId;//QuestNo
    // TODO: Lookup
    private long MsgNo;
    private float MsgDispTime;
    private float MsgWaitTime;
    private boolean IsUseSerial;
    private boolean IsHideMessage;

    public FSMBaseParamCallMessage(long msgType, long questId, long msgNo, float msgDispTime, float msgWaitTime, boolean isUseSerial, boolean isHideMessage) {
        MsgType = msgType;
        MsgTypeName = ParamCallMessageType.of((int) MsgType);
        QuestId = questId;
        MsgNo = msgNo;
        MsgDispTime = msgDispTime;
        MsgWaitTime = msgWaitTime;
        IsUseSerial = isUseSerial;
        IsHideMessage = isHideMessage;
    }
}
