package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.EM;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;

import java.util.List;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class CharParamEnemyFly extends CharParamEnemy {
    private float hoverSpeed;
    private List<Float> hoverAltitude;
    private int hoverLevelMax;
    private int hoverLevelRange;
    private float flySpeed;
    private float flyAltitude;

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
