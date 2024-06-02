package org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.season3.quest;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.season3.stage.SetInfo;

@RequiredArgsConstructor
@Getter
@JsonPropertyOrder(alphabetic = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class QuestSetInfoOmBowlOfLife extends SetInfo {
    private final QuestSetInfoOm InfoOm;
    private final boolean WaitBowlOfLife;
    private final boolean FullBowlOfLife;
    private final boolean SetEM;
    private final boolean Invisible;
    private final boolean IsQuest;
    private final long QuestId;
    private final int Kind;
    private final int Group;
    private final int ID;
}
