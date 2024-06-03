package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.marker;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.lib.common.entity.TopLevelClientResource;

import java.util.List;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class DungeonMarker extends TopLevelClientResource {
    private int WarpStageNo;
    private List<DungeonMarkerWarpInfo> WarpInfoList;
    private List<DungeonMarkerPosition> PositionList;
}
