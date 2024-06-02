package org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.clankyoten;

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
