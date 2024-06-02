package org.sehkah.ddon.tools.extractor.season3.resource.entity.EM;

import java.util.List;

public record ParentRegionStatusParam(
        long No,
        long RegionCategory,
        boolean IsReGenerate,
        long RegenerateProperty,
        List<Long> HpForEdit,
        float ShPMax,
        float ShPSpeed,
        float ShPResetTimerMax,
        float BlPMax,
        float BlPSpeed,
        float BlResetTimerMax,
        float DownPMax,
        float DownPSpeed,
        float DownPResetTimerMax,
        float ShakePMax,
        float ShakePSpeed,
        float ShakeResetTimerMax,
        float RageShrinkMax,
        boolean IsDamageToMain,
        long BreakReactionNo,
        RegionBreakInfoTable BreakInfo
) {
}
