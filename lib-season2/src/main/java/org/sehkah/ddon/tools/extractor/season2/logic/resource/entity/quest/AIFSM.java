package org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.quest;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.api.entity.TopLevelClientResource;

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
public class AIFSM extends TopLevelClientResource {
    private String OwnerObjectName;
    private AIFSMCluster RootCluster;
    //private AIConditionTree ConditionTree;
    // long FSMAttribute;
    // long LastEditType;
}
