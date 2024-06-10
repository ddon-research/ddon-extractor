package org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.base;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.api.entity.Resource;
import org.sehkah.ddon.tools.extractor.api.serialization.MetaInformation;

import java.util.List;
import java.util.Optional;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class StageListInfoList extends Resource {
    @MetaInformation
    private long StageListInfoListSize;
    private List<StageListInfo> StageListInfoList;

    public StageListInfo getStageByStageNo(int stageNo) {
        return getStageByStageNoNaive(stageNo);
    }

    private StageListInfo getStageByStageNoNaive(long stageNo) {
        Optional<StageListInfo> stageListInfo = StageListInfoList.stream().filter(i -> i.getStageNo() == stageNo).findFirst();
        return stageListInfo.orElse(null);
    }

    public StageListInfo getStageByStageId(int stageId) {
        return getStageByStageIdNaive(stageId);
    }

    private StageListInfo getStageByStageIdNaive(long stageNo) {
        Optional<StageListInfo> stageListInfo = StageListInfoList.stream().filter(i -> i.getStageId() == stageNo).findFirst();
        return stageListInfo.orElse(null);
    }
}
