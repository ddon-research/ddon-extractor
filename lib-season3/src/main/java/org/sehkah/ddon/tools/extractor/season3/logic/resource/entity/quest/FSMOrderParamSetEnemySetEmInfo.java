package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.quest;


import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.api.datatype.Matrix;
import org.sehkah.ddon.tools.extractor.api.logic.resource.Translation;
import org.sehkah.ddon.tools.extractor.api.serialization.MetaInformation;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class FSMOrderParamSetEnemySetEmInfo extends AICopiableParameter {
    private long EnemyId;
    @MetaInformation
    private Translation EnemyName;
    private Matrix Mat;
    private FSMRelate FsmPath;
    private long ErosionLv;
    // season 3 exclusive
    private long ArmedSetMode;
    private boolean IsNoSetPS3;
    //
    private long GroupId;
    private long SetId;
}
