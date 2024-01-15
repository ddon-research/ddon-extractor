package org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.stage;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class SetInfoOmBowlOfLife extends SetInfo {
    private final boolean WaitBowlOfLife;
    private final boolean FullBowlOfLife;
    private final boolean SetEM;
    private final boolean Invisible;
    private final boolean IsQuest;
    private final long QuestId;
    private final int Kind;
    private final int Group;
    private final int ID;
    private final SetInfoOm InfoOm;
}
