package org.sehkah.ddon.tools.extractor.season3.resource.entity.stage;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
@JsonPropertyOrder(alphabetic = true)
public class SetInfoOmUnknown46 extends SetInfo {
    private final long UnknownStageNo; // TODO Not sure if this is really a stage no
    private final long QuestId;
    private final long Unknown1;
    private final long Unknown2;
    private final SetInfoOmOld InfoOm;
}
