package org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.stage;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
@JsonPropertyOrder(alphabetic = true)
public class SetInfoOmUnknown42 extends SetInfo {
    private final boolean Unknown1;
    private final int Unknown2;
    private final int Unknown3;
    private final int Unknown4;
    private final int Unknown5;
    private final int Unknown6;
    private final boolean Unknown7;
    private final SetInfoOmOld InfoOm;
}
