package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.stage;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
@JsonPropertyOrder(alphabetic = true)
public class SetInfoEnemyV2 extends SetInfo {
    private final int Unknown1;
    private final int PresetKind;
    private final int Group;
    private final long EmReactNo;
    private final int SubGroupNo;
    private final boolean ReturnPoint2nd;
    private final long Unknown2;
    private final SetInfoCoord InfoCharacter;
}
