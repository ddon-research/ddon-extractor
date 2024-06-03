package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.quest;

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
public class AIFSMNode {
    private String Name;
    private long Id;
    private long UniqueId;
    private long OwnerId;
    private AIFSMCluster SubCluster;
    private long LinkListNum;
    private List<AIFSMLink> LinkList;
    private long ProcessListNum;
    private List<AIFSMNodeProcess> ProcessList;
    private AIFSMNodeUIPos UIPos;
    private int ColorType;
    private long Setting;
    private long UserAttribute;
    private boolean ExistConditionTrainsitionFromAll;
    private long ConditionTrainsitionFromAllId;
}
