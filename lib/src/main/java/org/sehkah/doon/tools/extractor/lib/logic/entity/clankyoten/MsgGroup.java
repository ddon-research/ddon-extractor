package org.sehkah.doon.tools.extractor.lib.logic.entity.clankyoten;

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
