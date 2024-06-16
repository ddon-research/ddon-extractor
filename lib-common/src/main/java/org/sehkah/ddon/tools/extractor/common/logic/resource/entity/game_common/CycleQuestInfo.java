package org.sehkah.ddon.tools.extractor.common.logic.resource.entity.game_common;

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
public class CycleQuestInfo {
    private long CycleNo;
    private long CycleSubNo;
    // TODO: Lookup
    private long ContentNameIdx;
    private long ContentInfoIdx;
    private long GatherInfoIdx;
    private List<CycleQuestSituationInfo> SituationInfo;
    private long GatherNpcId;
    @MetaInformation
    private Translation GatherNpcName;
    private long GatherStageNo;
    @MetaInformation
    private Translation GatherStageName;
    private long GatherStartPos;
}
