package org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.EM;

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
public class ParentRegionStatusParam {
    private long No;
    private long RegionCategory;
    private boolean IsReGenerate;
    private long RegenerateProperty;
    private List<Long> HpForEdit;
    private float ShPMax;
    private float ShPSpeed;
    private float ShPResetTimerMax;
    private float BlPMax;
    private float BlPSpeed;
    private float BlResetTimerMax;
    private float DownPMax;
    private float DownPSpeed;
    private float DownPResetTimerMax;
    private float ShakePMax;
    private float ShakePSpeed;
    private float ShakeResetTimerMax;
    private float RageShrinkMax;
    private boolean IsDamageToMain;
    private long BreakReactionNo;
    private RegionBreakInfoTable BreakInfo;
}
