package org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season2.quest;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.sehkah.ddon.tools.extractor.lib.common.entity.TopLevelClientResource;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@RequiredArgsConstructor
@Getter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
/**
 * Used in quests, events, stages
 */
public final class AIFSM extends TopLevelClientResource {
    private final String OwnerObjectName;
    private final AIFSMCluster RootCluster;
    //private final AIConditionTree ConditionTree;
    // long FSMAttribute;
    // long LastEditType;
}
