package org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.clankyoten;

import java.util.List;

public record MsgGroup(
        long GroupSerial,
        long NpcId,
        long GroupNameSerial,
        long GroupType,
        boolean NameDispOff,
        List<MsgData> MsgData
) {
}
