package org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.season2.quest;


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
public final class FSMBaseParamCallMessageFortDefBattleStart extends FSMBaseParamCallMessage {
    private final long Type;
    private final int GotoPointNo;

    public FSMBaseParamCallMessageFortDefBattleStart(FSMBaseParamCallMessage callMessage, long type, int gotoPointNo) {
        super(callMessage.getMsgType(), callMessage.getQuestId(), callMessage.getMsgNo(), callMessage.getMsgDispTime(), callMessage.getMsgWaitTime(), callMessage.isIsUseSerial(), callMessage.isIsHideMessage());
        Type = type;
        GotoPointNo = gotoPointNo;
    }
}
