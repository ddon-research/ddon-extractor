package org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.stage;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.lib.common.datatype.OrientedBoundingBox;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class SetInfoOmWall extends SetInfo {
    private long WallType;
    private OrientedBoundingBox NavOBB;
    private SetInfoOm InfoOm;
}
