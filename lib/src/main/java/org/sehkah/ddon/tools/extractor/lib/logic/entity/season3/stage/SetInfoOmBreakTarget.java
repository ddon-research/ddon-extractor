package org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.stage;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class SetInfoOmBreakTarget extends SetInfo {
    private final long BreakHitNum;
    private final SetInfoOm InfoOm;
}
