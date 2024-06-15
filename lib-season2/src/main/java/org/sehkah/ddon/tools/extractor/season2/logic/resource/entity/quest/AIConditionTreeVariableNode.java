package org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.quest;


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
public class AIConditionTreeVariableNode extends AIConditionTreeNode {
    private List<AIConditionTreeNode> ChildList;
    private AIConditionTreeVariableNodeVariableInfo Variable;
    private boolean IsBitNo;
    private boolean IsArray;
    private boolean IsDynamicIndex;
    private long Index;
    private AIConditionTreeVariableNodeVariableInfo IndexVariable;
    private boolean UseEnumIndex;
    private AIEnumProp IndexEnum;
}
