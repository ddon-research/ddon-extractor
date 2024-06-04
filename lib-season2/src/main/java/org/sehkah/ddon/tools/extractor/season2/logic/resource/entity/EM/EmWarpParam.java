package org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.EM;

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
public class EmWarpParam {
    private List<Float> WarpDist;//3
    private float GroundCheckDist;
    private boolean IsGroundCheckExtend;
}
