package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.quest;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.api.datatype.Vector3f;
import org.sehkah.ddon.tools.extractor.api.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.stage.meta.SetInfoCoordOmIdType;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class QuestSetInfoCoord {
    private String Name;
    private int UnitID;
    @MetaInformation
    private SetInfoCoordOmIdType UnitIDType;
    private Vector3f Position;
    private Vector3f Angle;
    private Vector3f Scale;
    private int AreaHitNo;
    private long Version;

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
