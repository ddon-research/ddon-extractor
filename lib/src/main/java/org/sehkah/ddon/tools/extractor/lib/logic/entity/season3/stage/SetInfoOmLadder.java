package org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.stage;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class SetInfoOmLadder extends SetInfo {
    private final long Height;
    private final SetInfoOm InfoOm;
}
