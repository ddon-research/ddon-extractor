package org.sehkah.ddon.tools.extractor.season3.resource.entity.clankyoten;

public record MsgData(
        long MsgSerial,
        long GmdIndex,
        long MsgType,
        long JumpGroupSerial,
        long DispType,
        long DispTime,
        long SetMotion,
        int VoiceReqNo,
        int TalkFaceType
) {
}
