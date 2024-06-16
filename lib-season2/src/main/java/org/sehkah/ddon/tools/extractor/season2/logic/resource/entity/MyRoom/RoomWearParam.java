package org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.MyRoom;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.api.logic.resource.Translation;
import org.sehkah.ddon.tools.extractor.api.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.MyRoom.meta.RoomWearType;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class RoomWearParam {
    private long ItemId;
    @MetaInformation
    private Translation ItemName;
    private long Type;
    @MetaInformation
    private RoomWearType TypeName;
    private int AH_M;
    private int AB_M;
    private int WB_M;
    private int AA_M;
    private int AL_M;
    private int WL_M;
    private int AC_M;
    private int AH_W;
    private int AB_W;
    private int WB_W;
    private int AA_W;
    private int AL_W;
    private int WL_W;
    private int AC_W;
}
