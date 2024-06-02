package org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.season3.EM;

import org.sehkah.ddon.tools.extractor.lib.common.datatype.Vector3f;
import org.sehkah.ddon.tools.extractor.lib.common.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.lib.common.util.BitUtil;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.season3.EM.meta.GameElementType;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.season3.EM.meta.ShotReqInfo2Type;

import java.util.Set;

public record ShotReqInfo2Param(
        boolean IsUse,
        long ShotFlag,
        @MetaInformation
        Set<ShotReqInfo2Type> ShotFlagTypes,
        long ShotGroup,
        long ShotIndex,
        long SetTarget,
        long JointNo,
        boolean IsConst,
        Vector3f OffsetPos,
        Vector3f OffsetDir,
        boolean IsLockOnTarget,
        long LiveRegionNo,
        int EnchantElementType,
        @MetaInformation
        GameElementType EnchantElementTypeName,
        boolean UseAbsolutePos,
        float HpRateLimit1,
        float HpRateLimit2
) {

    public ShotReqInfo2Param(boolean isUse, long shotFlag, long shotGroup, long shotIndex, long setTarget,
                             long jointNo, boolean isConst, Vector3f offsetPos, Vector3f offsetDir,
                             boolean isLockOnTarget, long liveRegionNo, int enchantElementType, boolean useAbsolutePos,
                             float hpRateLimit1, float hpRateLimit2) {
        this(isUse,
                shotFlag, BitUtil.extractBitSetUnsignedIntegerFlag(ShotReqInfo2Type::of, i -> 1 << i, shotFlag),
                shotGroup,
                shotIndex,
                setTarget,
                jointNo,
                isConst,
                offsetPos,
                offsetDir,
                isLockOnTarget,
                liveRegionNo,
                enchantElementType, GameElementType.of(enchantElementType),
                useAbsolutePos,
                hpRateLimit1,
                hpRateLimit2);
    }
}
