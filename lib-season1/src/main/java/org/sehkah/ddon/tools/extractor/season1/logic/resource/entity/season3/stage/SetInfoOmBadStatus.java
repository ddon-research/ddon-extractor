package org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.season3.stage;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.sehkah.ddon.tools.extractor.lib.common.datatype.Vector3f;

@RequiredArgsConstructor
@Getter
@JsonPropertyOrder(alphabetic = true)
public class SetInfoOmBadStatus extends SetInfo {
    private final float BadRadius;
    private final float BadHeight;
    private final Vector3f BadPos;
    private final long BreakHitNum;
    private final SetInfoOmOld InfoOm;
}
