package org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.stage;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.sehkah.ddon.tools.extractor.lib.common.datatype.OrientedBoundingBox;

@RequiredArgsConstructor
@Getter
public class SetInfoOmWall extends SetInfo {
    private final long WallType;
    private final OrientedBoundingBox NavOBB;
    private final SetInfoOm InfoOm;
}
