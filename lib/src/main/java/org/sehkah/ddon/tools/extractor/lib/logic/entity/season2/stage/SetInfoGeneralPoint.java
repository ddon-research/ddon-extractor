package org.sehkah.ddon.tools.extractor.lib.logic.entity.season2.stage;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
@JsonPropertyOrder(alphabetic = true)
public class SetInfoGeneralPoint extends SetInfo {
    private final SetInfoCoord InfoCoord;
    private final float Radius;
    private final int ObjectID;
    private final int Group;
}
