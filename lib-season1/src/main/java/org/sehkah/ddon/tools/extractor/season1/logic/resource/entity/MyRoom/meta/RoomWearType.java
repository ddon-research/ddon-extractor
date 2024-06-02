package org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.MyRoom.meta;

import java.util.Arrays;

public enum RoomWearType {
    TYPE_PL_ROOM(0x0),
    TYPE_PAWN_ROOM(0x1),
    TYPE_PAWN_BATH(0x2),
    TYPE_PAWN_SLEEP(0x3);

    public final long value;

    RoomWearType(long value) {
        this.value = value;
    }

    public static RoomWearType of(long value) {
        return Arrays.stream(RoomWearType.values()).filter(t -> t.value == value).findFirst().orElse(null);
    }
}
