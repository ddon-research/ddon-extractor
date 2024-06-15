package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.game_common;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;

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
    private long StageNo2;
    private long StageNo3;
    private boolean Unknown;
}
