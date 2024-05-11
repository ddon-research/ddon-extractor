package org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season2.stage;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
@JsonPropertyOrder(alphabetic = true)
public class SetInfoEnemy extends SetInfo {
    private final int PresetKind;
    private final int Group;
    private final long EmReactNo;
    private final int SubGroupNo;
    private final boolean ReturnPoint2nd;
    private final SetInfoCoord InfoCharacter;
}
