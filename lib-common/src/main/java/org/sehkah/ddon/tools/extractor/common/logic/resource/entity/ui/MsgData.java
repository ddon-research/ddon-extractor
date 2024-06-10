package org.sehkah.ddon.tools.extractor.common.logic.resource.entity.ui;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.api.logic.resource.Translation;
import org.sehkah.ddon.tools.extractor.api.serialization.MetaInformation;

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
    @MetaInformation
    private Translation Message;
    private long MsgType;//3 == quest examine data, 1 == quest message data
    private long JumpGroupSerial;
    private long DispType;
    private long DispTime;
    private long SetMotion;
    private int VoiceReqNo;
    private int TalkFaceType;
}
