package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.MyRoom;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.api.datatype.Vector3f;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class MyRoomActParam {
    private Vector3f Pos;
    private float AngleY;
    private int Waypoint;
    private int NpcMotNo;
    private int StartIdx;
    private boolean IsGriffin;
    private long NeedOM2;
    private long NeedOM3;
    private long NeedOM4;
    private long NeedOM5;
    private boolean Unknown;
}
