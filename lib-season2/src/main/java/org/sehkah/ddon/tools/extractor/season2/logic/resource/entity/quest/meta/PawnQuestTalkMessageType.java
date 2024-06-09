package org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.quest.meta;

import java.util.Arrays;

public enum PawnQuestTalkMessageType {
    MSGTYPE_BATTLE_ORDER_UI(0x0),
    MSGTYPE_BATTLE_ORDER(0x1),
    MSGTYPE_BATTLE_NO_ORDER(0x2),
    MSGTYPE_BATTLE_TALK(0x3),
    MSGTYPE_DELIVER_ORDER_UI(0x4),
    MSGTYPE_DELIVER_ORDER(0x5),
    MSGTYPE_DELIVER_NO_ORDER(0x6),
    MSGTYPE_DELIVER_DELIVER(0x7),
    MSGTYPE_DELIVER_NO_DELIVER(0x8),
    MSGTYPE_PHOTO_ORDER_UI(0x9),
    MSGTYPE_PHOTO_ORDER(0xA),
    MSGTYPE_PHOTO_NO_ORDER(0xB),
    MSGTYPE_PHOTO_TALK(0xC),
    MSGTYPE_PHOTO_CLEAR(0xD);

    public final long value;

    PawnQuestTalkMessageType(long value) {
        this.value = value;
    }

    public static PawnQuestTalkMessageType of(long value) {
        return Arrays.stream(PawnQuestTalkMessageType.values()).filter(pawnQuestTalkMessageType -> pawnQuestTalkMessageType.value == value).findFirst().orElse(null);
    }
}
