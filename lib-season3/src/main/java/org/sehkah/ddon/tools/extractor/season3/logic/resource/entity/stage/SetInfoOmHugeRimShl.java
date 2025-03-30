package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.stage;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.api.datatype.Vector3f;
import org.sehkah.ddon.tools.extractor.api.logic.resource.Translation;
import org.sehkah.ddon.tools.extractor.api.serialization.MetaInformation;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
// e.g. Thunderstorms in Urteca
public class SetInfoOmHugeRimShl extends SetInfo {
    private int ShotGrp;
    private long ShotInterval;
    private int WeatherID;
    private long StartHour;
    private long EndHour;
    private boolean Boundary;
    private Vector3f BoundaryPos;
    private float BoundaryRadius;
    private boolean Block;
    // TODO: Lookup
    private int Kind;
    private int Grp;
    private int ID;
    private boolean BlockQuest;
    private long BlockQuestID;
    @MetaInformation
    private Translation BlockQuestName;
    private long BlockQuestFlag;
    private SetInfoOmOld InfoOm;
}
