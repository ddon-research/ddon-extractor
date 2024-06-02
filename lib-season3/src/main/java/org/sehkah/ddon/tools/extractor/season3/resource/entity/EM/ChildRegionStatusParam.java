package org.sehkah.ddon.tools.extractor.season3.resource.entity.EM;

import org.sehkah.ddon.tools.extractor.lib.common.datatype.Vector3f;

import java.util.List;

public record ChildRegionStatusParam(
        long No,
        List<Long> ParentNo, //2
        List<Float> AttackTolerance, //4
        List<Float> MagicTolerance, //7
        float ShrinkAdj,
        float BlowAdj,
        float DownAdj,
        float OcdAdj,
        List<Float> ShakeAdjPhys, //4
        List<Float> ShakeAdjMagic, //7
        float ShakeAdjShake,
        float HitStopAdj,
        float HitSlowAdj,
        List<Float> ShrinkDamageRatePhys,//4
        List<Float> ShrinkDamageRateMagic,//7
        List<Float> BlowDamageRatePhys,//4
        List<Float> BlowDamageRateMagic,//7
        List<Float> DownDamageRatePhys,//4
        List<Float> DownDamageRateMagic,//7
        long HitStopDefenceAttr,
        long Surface,
        boolean IsClimbBonus,
        boolean IsDownWeakRegion,
        long CorePointType,
        int CorePointID,
        int CoreJointNo,
        Vector3f CoreJointOffset,
        int CoreEpvIndex,
        int CoreEpvElementNo,
        List<Long> AttackReactionType, //4
        List<Boolean> IsElementWeakRegion //6
) {
}
