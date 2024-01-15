package org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.stage;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class SetInfoGeneralPoint extends SetInfo {
    private final SetInfoCoord InfoCoord;
    private final float Radius;
    private final int ObjectID;
    private final int Group;
}
