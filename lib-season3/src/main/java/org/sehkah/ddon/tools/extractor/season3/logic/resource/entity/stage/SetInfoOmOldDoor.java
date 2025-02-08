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
public class SetInfoOmOldDoor extends SetInfo {
    private boolean IsQuest;
    private long QuestId;
    @MetaInformation
    private Translation QuestName;
    private int Kind0;
    private int Group0;
    private int ID0;
    private int Kind1;
    private int Group1;
    private int ID1;
    private int Kind2;
    private int Group2;
    private int ID2;
    private SetInfoOmOld InfoOm;
}
