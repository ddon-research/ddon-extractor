package org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.quest;


import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.api.datatype.Matrix;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class FSMOrderParamSetEnemySetEmInfo extends AICopiableParameter {
    private long EnemyId;
    private Matrix Mat;
    private FSMRelate FsmPath;
    private long GroupId;
    private long SetId;
    private long ErosionLv;
}
