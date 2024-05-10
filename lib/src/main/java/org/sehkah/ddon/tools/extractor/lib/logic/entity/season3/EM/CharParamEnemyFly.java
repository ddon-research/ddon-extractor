package org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.EM;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Getter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
@JsonPropertyOrder(alphabetic = true)
public class CharParamEnemyFly extends CharParamEnemy {
    private final float hoverSpeed;
    private final List<Float> hoverAltitude;
    private final int hoverLevelMax;
    private final int hoverLevelRange;
    private final float flySpeed;
    private final float flyAltitude;

    public CharParamEnemyFly(CharParamEnemy charParamEnemy, float hoverSpeed, List<Float> hoverAltitude, int hoverLevelMax, int hoverLevelRange, float flySpeed, float flyAltitude) {
        super(charParamEnemy.getAttackBasePhys(), charParamEnemy.getAttackBaseMagic(), charParamEnemy.getAttackWepPhys(), charParamEnemy.getAttackWepMagic(), charParamEnemy.getDefenceBasePhys(), charParamEnemy.getDefenceBaseMagic(), charParamEnemy.getDefenceWepPhys(), charParamEnemy.getDefenceWepMagic(),
                charParamEnemy.getPower(), charParamEnemy.getWeight(), charParamEnemy.getGuardAttackBase(), charParamEnemy.getGuardDefenceBase(),
                charParamEnemy.getGuardDefenceWep(), charParamEnemy.getWeaponTypeSe(), charParamEnemy.getEnemyBodySizeSe(), charParamEnemy.getPushGroup(),
                charParamEnemy.getScrAdjustType(), charParamEnemy.getScrAdjustSize(), charParamEnemy.getShakeCureRateRage(), charParamEnemy.getJumpAttackSpeed(),
                charParamEnemy.getFallDamageCheckHeight(), charParamEnemy.getUseMotionBlendNum(), charParamEnemy.isUseMotionHistory(),
                charParamEnemy.getUseMotionHistoryNum(), charParamEnemy.getReturnTerritoryContTime(), charParamEnemy.getBeardownEffective(),
                charParamEnemy.getGuardCounter(), charParamEnemy.getGuardReactionCheckType(), charParamEnemy.getEnemyScaleBase(), charParamEnemy.getEnemyScaleThinkTable(),
                charParamEnemy.isIsShakedActionEnemy(), charParamEnemy.getMcThinkMgrScaleParam(), charParamEnemy.getEnemyLinkRadiusA(), charParamEnemy.isEnemyLinkRadiusBOn(),
                charParamEnemy.getEnemyLinkRadiusB(), charParamEnemy.getEvaluationPLJobs(),
                charParamEnemy.getEvaluationPLSex(), charParamEnemy.isDownPerformanceOff(), charParamEnemy.isIsDispDownGuage(), charParamEnemy.isIsNoneAdbantageBGM(),
                charParamEnemy.isIsUseEnchant(), charParamEnemy.getEnchantType(), charParamEnemy.getDamageSpecialAdjType(), charParamEnemy.getDamageBounisFlag(),
                charParamEnemy.getShrinkBounisShakeRate(), charParamEnemy.getShakeRateSequence());
        this.hoverSpeed = hoverSpeed;
        this.hoverAltitude = hoverAltitude;
        this.hoverLevelMax = hoverLevelMax;
        this.hoverLevelRange = hoverLevelRange;
        this.flySpeed = flySpeed;
        this.flyAltitude = flyAltitude;
    }
}
