package org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.quest;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.sehkah.ddon.tools.extractor.lib.common.datatype.Vector3f;
import org.sehkah.ddon.tools.extractor.lib.common.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.stage.meta.SetInfoCoordOmIdType;

@RequiredArgsConstructor
@Getter
@JsonPropertyOrder(alphabetic = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class QuestSetInfoCoord {
    private final String Name;
    private final int UnitID;
    @MetaInformation
    private final SetInfoCoordOmIdType UnitIDType;
    private final Vector3f Position;
    private final Vector3f Angle;
    private final Vector3f Scale;
    private final int AreaHitNo;
    private final long Version;

    public QuestSetInfoCoord(String name, int unitID, Vector3f position, Vector3f angle, Vector3f scale, int areaHitNo, long version) {
        Name = name;
        UnitID = unitID;
        UnitIDType = SetInfoCoordOmIdType.of(unitID);
        Position = position;
        Angle = angle;
        Scale = scale;
        AreaHitNo = areaHitNo;
        Version = version;
    }
}
