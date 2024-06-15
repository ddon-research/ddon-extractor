package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.quest;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.api.entity.Resource;

/**
 * Used in quests, events, stages
 */
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class AIFSM extends Resource {
    private String OwnerObjectName;
    private AIFSMCluster RootCluster;
    private AIConditionTree ConditionTree;
    private long FSMAttribute;
    private long LastEditType;
}
