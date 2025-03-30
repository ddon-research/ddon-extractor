package org.sehkah.ddon.tools.extractor.common.logic.resource.entity.stage;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.api.entity.Resource;

import java.util.List;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class NavigationMesh extends Resource {
    private NavigationMeshHeader CoreHeader;
    private String Name;
    private long NumberOfVertex;
    private long NumberOfNode;
    private long NumberOfNodeInfo;
    private boolean NearWall;
    private List<NavigationMeshVertexObject> VertexObject;
    private List<NavigationMeshNodeData> Node;
    private AIPathBase PathBase;
    private long NumberOfTotalLink;
    private long NumberOfTotalAttribute;
    private long NumberOfTotalIndex;
    private List<NavigationMeshNodeInfo> NodeInfo;
    private AIQuadTree QuadTree;
}
