package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.npc;

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
public class SituationData {
    // TODO: Lookup
    private long GroupSerial;
    private long StartQuestId;
    @MetaInformation
    private Translation StartQuestName;
    private boolean IsStartQuestIdStart;
    private long EndQuestId;
    @MetaInformation
    private Translation EndQuestName;
    private boolean IsEndQuestIdStart;
    private long RangeStartQuestFlag;
    private long RangeEndQuestFlag;
}
