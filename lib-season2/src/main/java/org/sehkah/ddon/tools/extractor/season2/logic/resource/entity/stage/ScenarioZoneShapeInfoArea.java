package org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.stage;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.api.datatype.Vector3f;

import java.util.List;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class ScenarioZoneShapeInfoArea extends ScenarioZoneShapeInfoBase {
    private List<Vector3f> Vertex;
    private float Bottom;
    private float Height;
    private Vector3f ConcaveCrossPos;
    private boolean FlgConvex;
    private long ConcaveStatus;

    public ScenarioZoneShapeInfoArea(ScenarioZoneShapeInfoBase base, List<Vector3f> vertex, float bottom, float height, Vector3f concaveCrossPos, boolean flgConvex, long concaveStatus) {
        super(base.isIsNativeData(), base.getDecay());
        Vertex = vertex;
        Bottom = bottom;
        Height = height;
        ConcaveCrossPos = concaveCrossPos;
        FlgConvex = flgConvex;
        ConcaveStatus = concaveStatus;
    }
}
