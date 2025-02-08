package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.EM;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.api.datatype.Vector3f;
import org.sehkah.ddon.tools.extractor.api.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.api.util.BitUtil;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.EM.meta.GameElementType;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.EM.meta.ShotReqInfo2Type;

import java.util.Set;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class ShotReqInfo2Param {
    private boolean IsUse;
    private long ShotFlag;
    @MetaInformation
    private Set<ShotReqInfo2Type> ShotFlagTypes;
    private long ShotGroup;
    private long ShotIndex;
    private long SetTarget;
    private long JointNo;
    private boolean IsConst;
    private Vector3f OffsetPos;
    private Vector3f OffsetDir;
    private boolean IsLockOnTarget;
    private long LiveRegionNo;
    private int EnchantElementType;
    @MetaInformation
    private GameElementType EnchantElementTypeName;
    private boolean UseAbsolutePos;
    private float HpRateLimit1;
    private float HpRateLimit2;

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
