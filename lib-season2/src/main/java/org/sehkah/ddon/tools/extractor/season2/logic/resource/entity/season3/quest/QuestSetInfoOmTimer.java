package org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.season3.quest;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.season3.stage.SetInfo;

@RequiredArgsConstructor
@Getter
@JsonPropertyOrder(alphabetic = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class QuestSetInfoOmTimer extends SetInfo { // TODO: Figure out which Layout SetInfo Unknown class corresponds to this...
    private final QuestSetInfoOm InfoOm;
    private final float Timer;
}
