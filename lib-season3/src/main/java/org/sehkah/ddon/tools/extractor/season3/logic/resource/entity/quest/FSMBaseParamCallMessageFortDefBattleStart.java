package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.quest;


import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class FSMBaseParamCallMessageFortDefBattleStart extends FSMBaseParamCallMessage {
    private long Type;
    private int GotoPointNo;

    public FSMBaseParamCallMessageFortDefBattleStart(FSMBaseParamCallMessage callMessage, long type, int gotoPointNo) {
        super(callMessage.getMsgType(), callMessage.getMsgTypeName(), callMessage.getQuestId(), callMessage.getQuestName(), callMessage.getMsgNo(), callMessage.getMsgDispTime(), callMessage.getMsgWaitTime(), callMessage.isIsUseSerial(), callMessage.isIsHideMessage());
        Type = type;
        GotoPointNo = gotoPointNo;
    }
}
