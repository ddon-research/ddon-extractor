package org.sehkah.ddon.tools.extractor.season3.resource.entity.clankyoten;

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
