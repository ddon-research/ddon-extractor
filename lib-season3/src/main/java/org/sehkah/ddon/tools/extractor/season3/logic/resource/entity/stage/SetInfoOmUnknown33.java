package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.stage;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
@JsonPropertyOrder(alphabetic = true)
public class SetInfoOmUnknown33 extends SetInfo {
    private final long Unknown1;
    private final long Unknown2;
    private final long Unknown3;
    private final long Unknown4;
    private final SetInfoOmOld InfoOm;
}
