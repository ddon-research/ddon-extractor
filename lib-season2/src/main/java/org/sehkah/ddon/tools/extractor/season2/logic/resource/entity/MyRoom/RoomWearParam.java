package org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.MyRoom;

import org.sehkah.ddon.tools.extractor.lib.common.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.MyRoom.meta.RoomWearType;

public record RoomWearParam(
        long Item,
        long Type,
        @MetaInformation
        RoomWearType TypeName,
        int AH_M,
        int AB_M,
        int WB_M,
        int AA_M,
        int AL_M,
        int WL_M,
        int AC_M,
        int AH_W,
        int AB_W,
        int WB_W,
        int AA_W,
        int AL_W,
        int WL_W,
        int AC_W
) {
    public RoomWearParam(long item, long type, int AH_M, int AB_M, int WB_M, int AA_M, int AL_M, int WL_M, int AC_M,
                         int AH_W, int AB_W, int WB_W, int AA_W, int AL_W, int WL_W, int AC_W) {
        this(item,
                type, RoomWearType.of(type),
                AH_M,
                AB_M,
                WB_M,
                AA_M,
                AL_M,
                WL_M,
                AC_M,
                AH_W,
                AB_W,
                WB_W,
                AA_W,
                AL_W,
                WL_W,
                AC_W);
    }
}
