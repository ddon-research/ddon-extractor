package org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.season2.quest;


import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.sehkah.ddon.tools.extractor.lib.common.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.season3.quest.meta.ParamCallMessageType;


@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@RequiredArgsConstructor
@Getter
@JsonPropertyOrder(alphabetic = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class FSMBaseParamCallMessage extends AICopiableParameter {
    private final long MsgType;
    @MetaInformation
    private final ParamCallMessageType MsgTypeName;
    private final long QuestId;//QuestNo
    private final long MsgNo;
    private final float MsgDispTime;
    private final float MsgWaitTime;
    private final boolean IsUseSerial;
    private final boolean IsHideMessage;

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
