package org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.quest;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.sehkah.ddon.tools.extractor.lib.common.datatype.Vector3f;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.stage.SetInfo;

@RequiredArgsConstructor
@Getter
@JsonPropertyOrder(alphabetic = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class QuestSetInfoOmBadStatus extends SetInfo {
    private final QuestSetInfoOm InfoOm;
    private final float BadRadius;
    private final float BadHeight;
    private final Vector3f BadPos;
    private final long BreakHitNum;
}
