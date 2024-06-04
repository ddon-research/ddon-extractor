package org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.quest;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.lib.common.datatype.Vector3f;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.stage.SetInfo;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class QuestSetInfoOmBadStatus extends SetInfo {
    private QuestSetInfoOm InfoOm;
    private float BadRadius;
    private float BadHeight;
    private Vector3f BadPos;
    private long BreakHitNum;
}
