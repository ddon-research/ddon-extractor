package org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.stage;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@Getter
@JsonPropertyOrder(alphabetic = true)
public class SetInfoOmWarpNew extends SetInfo {
    private final long UnknownStageNo;
    private final List<Long> StageNo;
    private final List<Long> StartPosNo;
    private final List<Long> QuestNo;
    private final List<Long> FlagNo;
    private final List<Long> SpotId;
    private final long TextType;
    private final long TextQuestNo;
    private final long TextNo;
    private final SetInfoOm InfoOm;
}