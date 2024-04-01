package org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.stage;

import org.sehkah.ddon.tools.extractor.lib.common.datatype.Vector3f;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.stage.meta.SetInfoCoordOmIdType;
import org.sehkah.ddon.tools.extractor.lib.logic.serialization.MetaInformation;

public record SetInfoCoord(
        String Name,
        int UnitID,
        @MetaInformation
        SetInfoCoordOmIdType UnitIDType,
        Vector3f Position,
        Vector3f Angle,
        Vector3f Scale,
        int AreaHitNo
) {

    public SetInfoCoord(String name, int unitID, Vector3f position, Vector3f angle, Vector3f scale, int areaHitNo) {
        this(name,
                unitID, SetInfoCoordOmIdType.of(unitID),
                position,
                angle,
                scale,
                areaHitNo);
    }
}
