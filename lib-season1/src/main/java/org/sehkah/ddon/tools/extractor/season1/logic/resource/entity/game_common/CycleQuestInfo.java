package org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.game_common;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;

import java.util.List;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class CycleQuestInfo {
    private long CycleNo;
    private long CycleSubNo;
    private long ContentNameIdx;
    private long ContentInfoIdx;
    private long GatherInfoIdx;
    private List<CycleQuestSituationInfo> SituationInfo;
    private long GatherNpcId;
    private long GatherStageNo;
    private long GatherStartPos;
}
