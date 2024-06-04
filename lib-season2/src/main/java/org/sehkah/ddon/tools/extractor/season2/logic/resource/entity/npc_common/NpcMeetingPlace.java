package org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.npc_common;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class NpcMeetingPlace {
    private long NpcId;
    private int StageNo;
    private long StartPosNo;
}
