package org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.stage;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
@JsonPropertyOrder(alphabetic = true)
public class SetInfoOmUnknown53 extends SetInfo {
    private final long Unknown1;
    private final boolean Unknown2; // TODO Check if boolean might come first
    private final int Unknown3;
    private final SetInfoOmOld InfoOm;
}
