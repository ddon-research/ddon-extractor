package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.clankyoten;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class MsgData {
    private long MsgSerial;
    private long GmdIndex;
    private long MsgType;
    private long JumpGroupSerial;
    private long DispType;
    private long DispTime;
    private long SetMotion;
    private int VoiceReqNo;
    private int TalkFaceType;
}
