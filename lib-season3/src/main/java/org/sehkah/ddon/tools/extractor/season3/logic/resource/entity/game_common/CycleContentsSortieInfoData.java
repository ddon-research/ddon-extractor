package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.game_common;

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
public class CycleContentsSortieInfoData {
    private long CycleNo;
    private long CycleSubNo;
    private long StageNo1;
    @MetaInformation
    private Translation StageName1;
    private long StageNo2;
    @MetaInformation
    private Translation StageName2;
    private long StageNo3;
    @MetaInformation
    private Translation StageName3;
    private boolean Unknown;
}
