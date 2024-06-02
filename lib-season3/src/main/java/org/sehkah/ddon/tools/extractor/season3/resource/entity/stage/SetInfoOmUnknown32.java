package org.sehkah.ddon.tools.extractor.season3.resource.entity.stage;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
@JsonPropertyOrder(alphabetic = true)
public class SetInfoOmUnknown32 extends SetInfo {
    private final boolean Unknown1;
    private final long Unknown2;
    private final long Unknown3;
    private final long Unknown4;
    private final long Unknown5;
    private final long Unknown6;
    private final long Unknown7;
    private final float Unknown8;
    private final long Unknown9;
    private final SetInfoOmOld InfoOm;
}
