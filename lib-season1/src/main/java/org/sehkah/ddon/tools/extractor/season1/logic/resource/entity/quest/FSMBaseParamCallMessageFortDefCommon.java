package org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.quest;


import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class FSMBaseParamCallMessageFortDefCommon extends FSMBaseParamCallMessage {
    private long Type;
    private int GotoPointNo;

    public FSMBaseParamCallMessageFortDefCommon(FSMBaseParamCallMessage callMessage, long type, int gotoPointNo) {
        super(callMessage.getMsgType(), callMessage.getQuestId(), callMessage.getMsgNo(), callMessage.getMsgDispTime(), callMessage.getMsgWaitTime(), callMessage.isIsUseSerial(), callMessage.isIsHideMessage());
        Type = type;
        GotoPointNo = gotoPointNo;
    }
}
