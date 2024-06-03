package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.quest;


import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Getter
@JsonPropertyOrder(alphabetic = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public final class FSMBaseParamCallMessageFortDefCommon extends FSMBaseParamCallMessage {
    private final long Type;
    private final int GotoPointNo;

    public FSMBaseParamCallMessageFortDefCommon(FSMBaseParamCallMessage callMessage, long type, int gotoPointNo) {
        super(callMessage.getMsgType(), callMessage.getQuestId(), callMessage.getMsgNo(), callMessage.getMsgDispTime(), callMessage.getMsgWaitTime(), callMessage.isIsUseSerial(), callMessage.isIsHideMessage());
        Type = type;
        GotoPointNo = gotoPointNo;
    }
}
