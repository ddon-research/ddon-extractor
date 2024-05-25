package org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season2.quest;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season2.stage.SetInfo;

@RequiredArgsConstructor
@Getter
@JsonPropertyOrder(alphabetic = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class QuestSetInfoOmHakuryuu extends SetInfo {
    private final QuestSetInfoOm InfoOm;
    private final long StoneLevel;
}
