package org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.clankyoten;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.lib.common.datatype.Vector3f;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class FurnitureData {
    private Vector3f Pos;
    private Vector3f Angle;
    private long OmId;
}
