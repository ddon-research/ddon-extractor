package org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.quest;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;

import java.util.List;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class QuestStage {
    // TODO: Lookup
    private int StageNo;
    private List<QuestGroup> QuestGrp;
}
