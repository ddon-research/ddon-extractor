package org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season2.MyRoom;

import org.sehkah.ddon.tools.extractor.lib.common.datatype.Vector3f;

public record MyRoomActParam(
        Vector3f Pos,
        float AngleY,
        int Waypoint,
        int NpcMotNo,
        int StartIdx,
        long NeedOM,
        short Message,
        int Condition,
        short LinkActNo,
        int LinkActLv,
        short ChangeEquip,
        boolean IsGriffin,
        boolean IsNotAvoid,
        boolean IsSingle,
        long NeedOM2,
        long NeedOM3,
        long NeedOM4,
        long NeedOM5
) {
}
