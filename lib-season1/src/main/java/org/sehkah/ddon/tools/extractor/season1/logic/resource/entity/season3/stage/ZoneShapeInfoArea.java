package org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.season3.stage;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.sehkah.ddon.tools.extractor.lib.common.datatype.Vector3f;

import java.util.List;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Getter
@JsonPropertyOrder(alphabetic = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class ZoneShapeInfoArea extends ZoneShapeInfoBase {
    private final float Height;
    private final float Bottom;
    private final long ConcaveStatus;
    private final boolean FlgConvex;
    private final List<Vector3f> Vertex;
    private final Vector3f ConcaveCrossPos;

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
