package org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.EM;

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
public class EnemyStatusChange {
    private long GroupNo;
    private long GroupSubNo;
    private long NextGroupSubNo;
    private boolean NextGroupSubOneGo;
    private long SelectNo;
    private long Type;
    private long RepeatSetting;
    private long ChangeStatus;
    private List<Float> Param;
    private List<Float> SystemParam;
    private float SystemParamWait;
    private long BitContrlCommand;
    private boolean TypeReverse;
}
