package org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.season3.clankyoten;

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
