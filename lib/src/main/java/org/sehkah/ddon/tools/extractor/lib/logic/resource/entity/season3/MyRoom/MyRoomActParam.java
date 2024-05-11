package org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.MyRoom;

import org.sehkah.ddon.tools.extractor.lib.common.datatype.Vector3f;

public record MyRoomActParam(
        Vector3f Pos,
        float AngleY,
        int Waypoint,
        int NpcMotNo,
        int StartIdx,
        boolean IsGriffin,
        long NeedOM2,
        long NeedOM3,
        long NeedOM4,
        long NeedOM5,
        boolean Unknown
) {
}
