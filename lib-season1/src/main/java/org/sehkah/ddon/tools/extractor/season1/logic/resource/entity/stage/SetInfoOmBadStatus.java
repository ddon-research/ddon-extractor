package org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.stage;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.lib.common.datatype.Vector3f;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class SetInfoOmBadStatus extends SetInfo {
    private float BadRadius;
    private float BadHeight;
    private Vector3f BadPos;
    private long BreakHitNum;
    private SetInfoOm InfoOm;
}
