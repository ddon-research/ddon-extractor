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
public class FSMOrderParamSetEnemy extends AICopiableParameter {
    private List<FSMOrderParamSetEnemySetEmInfo> SetEnemyInfo;
    private long GroupId;
    private long LayoutId;
}
