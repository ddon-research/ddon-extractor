package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.quest;


import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;

import java.util.List;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class AIConditionTreeConstF32Node extends AIConditionTreeNode {
    private List<AIConditionTreeNode> ChildList;
    private float Value;
}
