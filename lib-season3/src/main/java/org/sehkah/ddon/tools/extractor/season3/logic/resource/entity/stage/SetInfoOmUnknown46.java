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
    // TODO Not sure if this is really a stage no
    //  Verify via lookup?
    private long UnknownStageNo;
    private long QuestId;
    @MetaInformation
    private Translation QuestName;
    private long Unknown1;
    private long Unknown2;
    private SetInfoOmOld InfoOm;
}
