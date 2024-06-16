package org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.marker.season2;

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
public class StageAdjoinList extends Resource {
    // TODO: Lookup
    private int StageNo;
    private List<AdjoinInfo> AdjoinInfoArray;
}
