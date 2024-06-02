package org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.season3.EM;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@ToString
@EqualsAndHashCode
@Getter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
@JsonPropertyOrder(alphabetic = true)
public class CharParamEnemy {
    private final float AttackBasePhys;
    private final float AttackBaseMagic;
    private final float AttackWepPhys;
    private final float AttackWepMagic;
    private final float DefenceBasePhys;
    private final float DefenceBaseMagic;
    private final float DefenceWepPhys;
    private final float DefenceWepMagic;
    private final float Power;
    private final float Weight;
    private final float GuardAttackBase;
    private final float GuardDefenceBase;
    private final float GuardDefenceWep;
    private final long WeaponTypeSe;
    private final long EnemyBodySizeSe;
    private final long PushGroup;
    private final long ScrAdjustType;
    private final long ScrAdjustSize;
    private final float ShakeCureRateRage;
    private final List<CharParamEnemyJumpAttackSpeed> JumpAttackSpeed;//4
    private final float FallDamageCheckHeight;
    private final long UseMotionBlendNum;
    private final boolean UseMotionHistory;
    private final long UseMotionHistoryNum;
    private final float ReturnTerritoryContTime;
    private final int BeardownEffective;
    private final List<CharParamEnemyGuardCounter> GuardCounter;//10
    private final long GuardReactionCheckType;
    private final float EnemyScaleBase;
    private final float EnemyScaleThinkTable;
    private final boolean IsShakedActionEnemy;
    private final float McThinkMgrScaleParam;
    private final float EnemyLinkRadiusA;
    private final boolean EnemyLinkRadiusBOn;
    private final float EnemyLinkRadiusB;
    private final List<Float> EvaluationPLJobs;
    private final List<Float> EvaluationPLSex;
    private final boolean DownPerformanceOff;
    private final boolean IsDispDownGuage;
    private final boolean IsNoneAdbantageBGM;
    private final boolean IsUseEnchant;
    private final long EnchantType;
    private final long DamageSpecialAdjType;
    private final long DamageBounisFlag;
    private final float ShrinkBounisShakeRate;
    private final float ShakeRateSequence;

    public CharParamEnemy(float attackBasePhys, float attackBaseMagic, float attackWepPhys, float attackWepMagic,
                          float defenceBasePhys, float defenceBaseMagic, float defenceWepPhys, float defenceWepMagic,
                          float power, float weight, float guardAttackBase, float guardDefenceBase, float guardDefenceWep,
                          long weaponTypeSe, long enemyBodySizeSe, long pushGroup, long scrAdjustType, long scrAdjustSize,
                          float shakeCureRateRage, List<CharParamEnemyJumpAttackSpeed> jumpAttackSpeed, float fallDamageCheckHeight,
                          long useMotionBlendNum, boolean useMotionHistory, long useMotionHistoryNum, float returnTerritoryContTime,
                          int beardownEffective, List<CharParamEnemyGuardCounter> guardCounter, long guardReactionCheckType,
                          float enemyScaleBase, float enemyScaleThinkTable, boolean isShakedActionEnemy, float mcThinkMgrScaleParam,
                          float enemyLinkRadiusA, boolean enemyLinkRadiusBOn, float enemyLinkRadiusB, List<Float> evaluationPLJobs,
                          List<Float> evaluationPLSex, boolean downPerformanceOff, boolean isDispDownGuage, boolean isNoneAdbantageBGM, boolean isUseEnchant, long enchantType, long damageSpecialAdjType, long damageBounisFlag, float shrinkBounisShakeRate, float shakeRateSequence) {
        AttackBasePhys = attackBasePhys;
        AttackBaseMagic = attackBaseMagic;
        AttackWepPhys = attackWepPhys;
        AttackWepMagic = attackWepMagic;
        DefenceBasePhys = defenceBasePhys;
        DefenceBaseMagic = defenceBaseMagic;
        DefenceWepPhys = defenceWepPhys;
        DefenceWepMagic = defenceWepMagic;
        Power = power;
        Weight = weight;
        GuardAttackBase = guardAttackBase;
        GuardDefenceBase = guardDefenceBase;
        GuardDefenceWep = guardDefenceWep;
        WeaponTypeSe = weaponTypeSe;
        EnemyBodySizeSe = enemyBodySizeSe;
        PushGroup = pushGroup;
        ScrAdjustType = scrAdjustType;
        ScrAdjustSize = scrAdjustSize;
        ShakeCureRateRage = shakeCureRateRage;
        JumpAttackSpeed = jumpAttackSpeed;
        FallDamageCheckHeight = fallDamageCheckHeight;
        UseMotionBlendNum = useMotionBlendNum;
        UseMotionHistory = useMotionHistory;
        UseMotionHistoryNum = useMotionHistoryNum;
        ReturnTerritoryContTime = returnTerritoryContTime;
        BeardownEffective = beardownEffective;
        GuardCounter = guardCounter;
        GuardReactionCheckType = guardReactionCheckType;
        EnemyScaleBase = enemyScaleBase;
        EnemyScaleThinkTable = enemyScaleThinkTable;
        IsShakedActionEnemy = isShakedActionEnemy;
        McThinkMgrScaleParam = mcThinkMgrScaleParam;
        EnemyLinkRadiusA = enemyLinkRadiusA;
        EnemyLinkRadiusBOn = enemyLinkRadiusBOn;
        EnemyLinkRadiusB = enemyLinkRadiusB;
        EvaluationPLJobs = evaluationPLJobs;
        EvaluationPLSex = evaluationPLSex;
        DownPerformanceOff = downPerformanceOff;
        IsDispDownGuage = isDispDownGuage;
        IsNoneAdbantageBGM = isNoneAdbantageBGM;
        IsUseEnchant = isUseEnchant;
        EnchantType = enchantType;
        DamageSpecialAdjType = damageSpecialAdjType;
        DamageBounisFlag = damageBounisFlag;
        ShrinkBounisShakeRate = shrinkBounisShakeRate;
        ShakeRateSequence = shakeRateSequence;
    }
}
