package org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season2.stage;

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
    private final SetInfoOm InfoOm;
}