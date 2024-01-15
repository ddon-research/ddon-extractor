package org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.stage;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class SetInfoOmRange extends SetInfo {
    private final float Range;
    private final long Grp;
    private final boolean IsAll;
    private final boolean IsOneTime;
    private final SetInfoOm InfoOm;
}
