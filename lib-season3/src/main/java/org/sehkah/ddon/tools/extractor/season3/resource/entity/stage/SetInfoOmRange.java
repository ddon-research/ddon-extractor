package org.sehkah.ddon.tools.extractor.season3.resource.entity.stage;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
@JsonPropertyOrder(alphabetic = true)
public class SetInfoOmRange extends SetInfo {
    private final float Range;
    private final long Grp;
    private final boolean IsAll;
    private final boolean IsOneTime;
    private final SetInfoOmOld InfoOm;
}
