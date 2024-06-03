package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.stage;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.sehkah.ddon.tools.extractor.lib.common.datatype.OrientedBoundingBox;

@RequiredArgsConstructor
@Getter
@JsonPropertyOrder(alphabetic = true)
public class SetInfoOmWall extends SetInfo {
    private final long WallType;
    private final OrientedBoundingBox NavOBB;
    private final SetInfoOmOld InfoOm;
}
