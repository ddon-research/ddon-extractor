package org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.stage;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class SetInfoEnemy extends SetInfo {
    private final int PresetKind;
    private final int Group;
    private final long EmReactNo;
    private final int SubGroupNo;
    private final boolean ReturnPoint2nd;
    private final SetInfoCoord InfoCharacter;
}
