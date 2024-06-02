package org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.season3.stage;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
@JsonPropertyOrder(alphabetic = true)
public class SetInfoOmUnknown30 extends SetInfo {
    private final long UnknownStageNo; // TODO Not sure if this is really a stage no
    private final long Unknown1;
    private final long QuestId;
    private final long Unknown2;
    private final SetInfoOmOld InfoOm;
}
