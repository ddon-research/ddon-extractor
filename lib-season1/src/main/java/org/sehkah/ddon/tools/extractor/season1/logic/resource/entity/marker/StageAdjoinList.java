package org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.marker;

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
public class StageAdjoinList extends TopLevelClientResource {
    private int StageNo;
    private List<AdjoinInfo> AdjoinInfoArray;
}
