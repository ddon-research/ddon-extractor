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
public class SetInfoOmBowlOfLife extends SetInfo {
    private boolean WaitBowlOfLife;
    private boolean FullBowlOfLife;
    private boolean SetEM;
    private boolean Invisible;
    private boolean IsQuest;
    private long QuestId;
    @MetaInformation
    private Translation QuestName;
    private int Kind;
    private int Group;
    private int ID;
    private SetInfoOmOld InfoOm;
}
