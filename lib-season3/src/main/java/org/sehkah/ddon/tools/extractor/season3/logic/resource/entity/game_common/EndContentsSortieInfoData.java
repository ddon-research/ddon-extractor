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
public class EndContentsSortieInfoData {
    private long QuestId;
    private long StageNo1;
    // TODO: Lookup
    private long StageNo2;
    private long StageNo3;
    private long Unknown2;
    private long Unknown3;
    private long Flag;
    private boolean Unknown4;
}
