package org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.job;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.lib.common.datatype.Matrix;
import org.sehkah.ddon.tools.extractor.lib.common.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.lib.common.util.BitUtil;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.job.meta.MagicChantCommandLevelType;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.job.meta.MagicChantEndType;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.job.meta.MagicChantShotOption;

import java.util.List;
import java.util.Set;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class MagicChantParam {
    private long ChantMot;
    private float ChantTime_Gi;
    private long EndType;
    @MetaInformation
    private Set<MagicChantEndType> EndTypes;
    private boolean IsChant2;
    private long Chant2Mot;
    private float Chant2Time_Gi;
    private long SetType;
    private boolean IsConst;
    private int JointNo;
    private long ShotOption;
    @MetaInformation
    private MagicChantShotOption ShotOptionType;
    private Matrix ShotPosOffset;
    private Matrix NoneLockOnPos;
    private Matrix NoneLockOnPosNext;
    private long ShotMot;
    private boolean IsMotLoop;
    private float ShotLoopingTime;
    private boolean IsUseShotLimitXAngle;
    private float ShotLimitXAngle;
    private long EndMotion;
    private long ChantCameraNumber;
    private long ShotCameraNumber;
    private long EndCameraNumber;
    private float ShlBornFrame;
    private long ShlGroupNumber;
    private long ShlIndexNumber;
    private long ShlGroupNumberNext;
    private long ShlIndexNumberNext;
    private boolean IsCanMove;
    private long ChantAttribute;
    private boolean IsUseChantCommand;
    private int ChantCommandLevel;
    @MetaInformation
    private MagicChantCommandLevelType ChantCommandLevelType;
    private int MagicCommandNo;
    private boolean IsUseAutoRock;
    private float AutoRockRange;
    private float AutoRockAngle;
    private int Chant2EffectIndex;
    private int Chant2EffectNumber;
    private float Chant2EffectFrame;
    private float Chant2SeFrame;
    private boolean IsSetCustomChantTime;
    private List<Float> CustomChantTime_Gi;
    private boolean IsAimTargetSpot;
    private float AimTargetSpotMaxRange;
    private float AimTargetSpotMinRange;
    private boolean IsNoChantSe;
    private float AddHealHate;

    public MagicChantParam(long chantMot, float chantTime_Gi, long endType, boolean isChant2, long chant2Mot,
                           float chant2Time_Gi, long setType, boolean isConst, int jointNo, long shotOption,
                           Matrix shotPosOffset, Matrix noneLockOnPos, Matrix noneLockOnPosNext, long shotMot,
                           boolean isMotLoop, float shotLoopingTime, boolean isUseShotLimitXAngle,
                           float shotLimitXAngle, long endMotion, long chantCameraNumber, long shotCameraNumber,
                           long endCameraNumber, float shlBornFrame, long shlGroupNumber, long shlIndexNumber,
                           long shlGroupNumberNext, long shlIndexNumberNext, boolean isCanMove, long chantAttribute,
                           boolean isUseChantCommand, int chantCommandLevel, int magicCommandNo, boolean isUseAutoRock,
                           float autoRockRange, float autoRockAngle, int chant2EffectIndex, int chant2EffectNumber,
                           float chant2EffectFrame, float chant2SeFrame, boolean isSetCustomChantTime,
                           List<Float> customChantTime_Gi, boolean isAimTargetSpot, float aimTargetSpotMaxRange,
                           float aimTargetSpotMinRange, boolean isNoChantSe, float addHealHate) {
        this(chantMot,
                chantTime_Gi,
                endType, BitUtil.extractBitSetUnsignedIntegerFlag(MagicChantEndType::of, i -> 1 << i, endType),
                isChant2,
                chant2Mot,
                chant2Time_Gi,
                setType,
                isConst,
                jointNo,
                shotOption, MagicChantShotOption.of(shotOption),
                shotPosOffset,
                noneLockOnPos,
                noneLockOnPosNext,
                shotMot,
                isMotLoop,
                shotLoopingTime,
                isUseShotLimitXAngle,
                shotLimitXAngle,
                endMotion,
                chantCameraNumber,
                shotCameraNumber,
                endCameraNumber,
                shlBornFrame,
                shlGroupNumber,
                shlIndexNumber,
                shlGroupNumberNext,
                shlIndexNumberNext,
                isCanMove,
                chantAttribute,
                isUseChantCommand,
                chantCommandLevel, MagicChantCommandLevelType.of(chantCommandLevel),
                magicCommandNo,
                isUseAutoRock,
                autoRockRange,
                autoRockAngle,
                chant2EffectIndex,
                chant2EffectNumber,
                chant2EffectFrame,
                chant2SeFrame,
                isSetCustomChantTime,
                customChantTime_Gi,
                isAimTargetSpot,
                aimTargetSpotMaxRange,
                aimTargetSpotMinRange,
                isNoChantSe,
                addHealHate);
    }
}
