package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.stage;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.api.logic.resource.Translation;
import org.sehkah.ddon.tools.extractor.api.serialization.MetaInformation;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class SetInfoOmUnknown46 extends SetInfo {
    private long QuestFlag1;
    private long QuestId1;
    @MetaInformation
    private Translation QuestName1;
    private long QuestFlag2;
    private long QuestId2;
    @MetaInformation
    private Translation QuestName2;
    private SetInfoOmOld InfoOm;
}
