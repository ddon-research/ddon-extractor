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
public class AnimalData {
    private Vector3f Pos;
    private Vector3f Angle;
}
