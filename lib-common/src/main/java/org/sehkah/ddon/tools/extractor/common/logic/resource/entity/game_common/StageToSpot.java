package org.sehkah.ddon.tools.extractor.common.logic.resource.entity.game_common;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.api.logic.resource.Translation;
import org.sehkah.ddon.tools.extractor.api.serialization.MetaInformation;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class StageToSpot {
    private long StageNo;
    @MetaInformation
    private Translation StageName;
    private long SpotId;
    @MetaInformation
    private Translation SpotName;
    private int RecommendLevel;
}
