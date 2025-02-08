package org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.marker;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.api.logic.resource.Translation;
import org.sehkah.ddon.tools.extractor.api.serialization.MetaInformation;

import java.util.List;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class DungeonMarkerWarpInfo {
    private short GroupNo;
    private int TargetStageNo;
    @MetaInformation
    private Translation TargetStageName;
    private short TargetGroupNo;
    private List<DungeonMarkerWarpInfoIndex> PosIndex;
}
