package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.EM;

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
public class CharParamEnemy {
    private float AttackBasePhys;
    private float AttackBaseMagic;
    private float AttackWepPhys;
    private float AttackWepMagic;
    private float DefenceBasePhys;
    private float DefenceBaseMagic;
    private float DefenceWepPhys;
    private float DefenceWepMagic;
    private float Power;
    private float Weight;
    private float GuardAttackBase;
    private float GuardDefenceBase;
    private float GuardDefenceWep;
    private long WeaponTypeSe;
    private long EnemyBodySizeSe;
    private long PushGroup;
    private long ScrAdjustType;
    private long ScrAdjustSize;
    private float ShakeCureRateRage;
    private List<CharParamEnemyJumpAttackSpeed> JumpAttackSpeed;//4
    private float FallDamageCheckHeight;
    private long UseMotionBlendNum;
    private boolean UseMotionHistory;
    private long UseMotionHistoryNum;
    private float ReturnTerritoryContTime;
    private int BeardownEffective;
    private List<CharParamEnemyGuardCounter> GuardCounter;//10
    private long GuardReactionCheckType;
    private float EnemyScaleBase;
    private float EnemyScaleThinkTable;
    private boolean IsShakedActionEnemy;
    private float McThinkMgrScaleParam;
    private float EnemyLinkRadiusA;
    private boolean EnemyLinkRadiusBOn;
    private float EnemyLinkRadiusB;
    private List<Float> EvaluationPLJobs;
    private List<Float> EvaluationPLSex;
    private boolean DownPerformanceOff;
    private boolean IsDispDownGuage;
    private boolean IsNoneAdbantageBGM;
    private boolean IsUseEnchant;
    private long EnchantType;
    private long DamageSpecialAdjType;
    private long DamageBounisFlag;
    private float ShrinkBounisShakeRate;
    private float ShakeRateSequence;
}
