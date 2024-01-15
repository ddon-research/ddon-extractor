package org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.stage;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class SetInfoOmBoard extends SetInfo {
    private final long BoardID;
    private final SetInfoOm InfoOm;
}
