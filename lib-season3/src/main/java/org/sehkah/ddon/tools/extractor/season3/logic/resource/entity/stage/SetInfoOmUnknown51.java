package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.stage;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
@JsonPropertyOrder(alphabetic = true)
public class SetInfoOmUnknown51 extends SetInfo {
    private final long Unknown1;
    private final long Flag;
    private final long Unknown3;
    private final SetInfoOmOld InfoOm;
}
