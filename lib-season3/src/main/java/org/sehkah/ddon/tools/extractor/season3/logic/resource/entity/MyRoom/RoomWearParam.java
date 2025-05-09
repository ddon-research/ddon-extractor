package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.MyRoom;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.api.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.MyRoom.meta.RoomWearType;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class RoomWearParam {
    private long Item;
    private long Type;
    @MetaInformation
    private RoomWearType TypeName;
    private int AH_M;
    private int AB_M;
    private int WB_M;
    private int AA_M;
    private int AL_M;
    private int WL_M;
    private int Category_M;
    private int MotNo_M;
    private int AC_M;
    private int AH_W;
    private int AB_W;
    private int WB_W;
    private int AA_W;
    private int AL_W;
    private int WL_W;
    private int AC_W;
    private int Category_W;
    private int MotNo_W;

    public RoomWearParam(long item, long type, int AH_M, int AB_M, int WB_M, int AA_M, int AL_M, int Category_M,
                         int MotNo_M, int WL_M, int AC_M, int AH_W, int AB_W, int WB_W, int AA_W, int AL_W,
                         int WL_W, int AC_W, int Category_W, int MotNo_W) {
        this(item,
                type, RoomWearType.of(type),
                AH_M,
                AB_M,
                WB_M,
                AA_M,
                AL_M,
                Category_M,
                MotNo_M,
                WL_M,
                AC_M,
                AH_W,
                AB_W,
                WB_W,
                AA_W,
                AL_W,
                WL_W,
                AC_W,
                Category_W,
                MotNo_W);
    }
}
