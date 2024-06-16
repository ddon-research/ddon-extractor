package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.marker;

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
public class StageAdjoinList2 extends Resource {
    // TODO: Lookup
    private int StageNo;
    private List<AdjoinInfo> AdjoinInfoArray;
    private List<JumpPosition2> JumpPositionArray;
}
