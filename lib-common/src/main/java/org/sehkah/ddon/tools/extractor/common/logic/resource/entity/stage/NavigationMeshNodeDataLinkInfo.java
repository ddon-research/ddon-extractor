package org.sehkah.ddon.tools.extractor.common.logic.resource.entity.stage;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class NavigationMeshNodeDataLinkInfo {
    private long LinkNodeIndex;
    private long Attribute;
    private long PortalNumber;
    private float LinkCost;
    private float Size;
    private float Height;
}
