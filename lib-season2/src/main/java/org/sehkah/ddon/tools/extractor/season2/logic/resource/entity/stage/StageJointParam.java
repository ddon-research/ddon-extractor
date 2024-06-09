package org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.stage;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;

import java.util.List;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class StageJointParam {
    private float StartX;
    private float StartZ;
    private float DeltaX;
    private float DeltaZ;
    private long AreaNumX;
    private long AreaNumZ;
    private List<List<Byte>> Area;
}
