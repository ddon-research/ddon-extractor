package org.sehkah.doon.tools.extractor.lib.logic.entity.clankyoten;

import java.util.List;

public record MsgSet(
        long NativeMsgGroupArrayNum,
        long NativeMsgDataArrayNum,
        List<MsgGroup> NativeMsgGroupArray
) {
}
