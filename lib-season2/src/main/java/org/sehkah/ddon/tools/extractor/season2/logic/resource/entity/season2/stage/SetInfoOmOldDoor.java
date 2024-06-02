package org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.season2.stage;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
@JsonPropertyOrder(alphabetic = true)
public class SetInfoOmOldDoor extends SetInfo {
    private final boolean IsQuest;
    private final long QuestId;
    private final int Kind0;
    private final int Group0;
    private final int ID0;
    private final int Kind1;
    private final int Group1;
    private final int ID1;
    private final int Kind2;
    private final int Group2;
    private final int ID2;
    private final SetInfoOm InfoOm;
}
