package org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.stage;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
@JsonPropertyOrder(alphabetic = true)
public class SetInfoOmUnknown28 extends SetInfo {
    private final int Unknown;
    private final int UnknownId; // TODO: Maybe Item ID?
    private final SetInfoOmOld InfoOm;
}
