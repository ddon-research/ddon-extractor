package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.scr;

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
public class MapSpotData {
    private Vector3f Pos;
    private long MessId;
    private int FloorNo;
    private int GroupNo;
    private boolean FloorCheck;
}
