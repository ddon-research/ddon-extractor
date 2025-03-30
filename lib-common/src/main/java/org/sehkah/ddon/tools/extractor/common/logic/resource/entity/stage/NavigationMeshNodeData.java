package org.sehkah.ddon.tools.extractor.common.logic.resource.entity.stage;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.api.datatype.Vector3f;

import java.util.List;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class NavigationMeshNodeData {
    private int Index;
    private long NumberOfAttribute;
    private List<Long> Attribute;
    private boolean Connect;
    private Vector3f Dir;
    private float Length;
    private long NumberOfCAttribute;
    private List<Long> CAttribute;
    private NavigationMeshNodeDataPolygonArea PolygonArea;
    private long NumberOfLink;
    private List<NavigationMeshNodeDataLinkInfo> LinkInformation;
}
