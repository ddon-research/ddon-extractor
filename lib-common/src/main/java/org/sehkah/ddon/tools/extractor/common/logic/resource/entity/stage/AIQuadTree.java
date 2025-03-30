package org.sehkah.ddon.tools.extractor.common.logic.resource.entity.stage;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.api.datatype.AxisAlignedBoundingBox;

import java.util.List;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class AIQuadTree extends AITreeBase {
    //    private boolean Multiple;
//    private Vector3f Pos;
//    private Vector3f XZ;
    private AxisAlignedBoundingBox TempRegion; //Uses padding, reused for all nodes/quad trees
    private List<AITreeBaseNode> Node; // based on the node data in the flattened navigation mesh

    public AIQuadTree(AITreeBase parent, AxisAlignedBoundingBox tempRegion, List<AITreeBaseNode> node) {
        super(parent.getNest(), parent.getNumberOfNode());
        TempRegion = tempRegion;
        Node = node;
    }
}
