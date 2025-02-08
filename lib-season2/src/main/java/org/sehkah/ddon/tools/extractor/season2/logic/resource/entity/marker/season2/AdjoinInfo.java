package org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.marker.season2;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.api.logic.resource.Translation;
import org.sehkah.ddon.tools.extractor.api.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.marker.AdjoinInfoIndex;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.marker.JumpPosition;

import java.util.List;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class AdjoinInfo {
    private int DestinationStageNo;
    @MetaInformation
    private Translation DestinationStageName;
    private int NextStageNo;
    @MetaInformation
    private Translation NextStageName;
    private List<JumpPosition> Positions;
    private List<AdjoinInfoIndex> Index;
    private int Priority;
}
