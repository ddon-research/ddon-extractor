package org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.stage;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.lib.common.datatype.Vector3f;

import java.util.List;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class ZoneShapeInfoArea extends ZoneShapeInfoBase {
    private float Height;
    private float Bottom;
    private long ConcaveStatus;
    private boolean FlgConvex;
    private List<Vector3f> Vertex;
    private Vector3f ConcaveCrossPos;

    public ZoneShapeInfoArea(ZoneShapeInfoBase base, float height, float bottom, long concaveStatus, boolean flgConvex, List<Vector3f> vertex, Vector3f concaveCrossPos) {
        super(base.getDecay());
        Height = height;
        Bottom = bottom;
        ConcaveStatus = concaveStatus;
        FlgConvex = flgConvex;
        Vertex = vertex;
        ConcaveCrossPos = concaveCrossPos;
    }
}
