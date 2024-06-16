package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.stage;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;

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
    // TODO: Lookup
    private long QuestId;
    private int Kind;
    private int Group;
    private int ID;
    private SetInfoOmOld InfoOm;
}
