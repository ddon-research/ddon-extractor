package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.quest;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.stage.SetInfo;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class QuestSetInfoOmBowlOfLife extends SetInfo {
    private QuestSetInfoOm InfoOm;
    private boolean WaitBowlOfLife;
    private boolean FullBowlOfLife;
    private boolean SetEM;
    private boolean Invisible;
    private boolean IsQuest;
    private long QuestId;
    private int Kind;
    private int Group;
    private int ID;
}
