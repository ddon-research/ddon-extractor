package org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.npc;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class SituationData {
    private long GroupSerial;
    // TODO: Lookup
    private long StartQuestId;
    private boolean IsStartQuestIdStart;
    // TODO: Lookup
    private long EndQuestId;
    private boolean IsEndQuestIdStart;
}
