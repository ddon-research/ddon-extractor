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
public class SetInfoOmFlagMapMarker extends SetInfo {
    private long RedQuestFlag;
    private long RedQuestID;
    @MetaInformation
    private Translation RedQuestName;
    private long BlueQuestFlag;
    private long BlueQuestID;
    @MetaInformation
    private Translation BlueQuestName;
    private SetInfoOmOld InfoOm;
}
