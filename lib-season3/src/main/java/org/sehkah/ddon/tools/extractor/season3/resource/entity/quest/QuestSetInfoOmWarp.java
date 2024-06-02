package org.sehkah.ddon.tools.extractor.season3.resource.entity.quest;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.sehkah.ddon.tools.extractor.season3.resource.entity.stage.SetInfo;

import java.util.List;

@RequiredArgsConstructor
@Getter
@JsonPropertyOrder(alphabetic = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class QuestSetInfoOmWarp extends SetInfo {
    private final QuestSetInfoOm InfoOm;
    private final List<Long> StageNo;
    private final List<Long> StartPosNo;
    private final List<Long> QuestNo;
    private final List<Long> FlagNo;
    private final List<Long> SpotId;
    private final long TextType;
    private final long TextQuestNo;
    private final long TextNo;
    private final boolean NoWarp;
}
