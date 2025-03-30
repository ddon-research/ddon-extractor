package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.event;

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
public class EventViewerSetInfoFlagData {
    private long QuestId;
    @MetaInformation
    private Translation QuestName;
    private long FlagNo;
}
