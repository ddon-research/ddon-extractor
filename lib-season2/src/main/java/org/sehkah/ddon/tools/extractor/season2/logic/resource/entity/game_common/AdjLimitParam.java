package org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.game_common;

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
public class AdjLimitParam {
    private List<Float> GuardAtkAdjMax;
    private List<Float> GuardAtkAdjMin;
    private List<Float> GuardDefAdjMax;
    private List<Float> GuardDefAdjMin;
    private List<Float> StaminaDamageAdjMax;
    private List<Float> StaminaDamageAdjMin;
    private List<Float> HpDamageAtkAdjMax;
    private List<Float> HpDamageAtkAdjMin;
    private List<Float> HpDamageDefAdjMax;
    private List<Float> HpDamageDefAdjMin;
    private List<Float> ShrinkAtkAdjMax;
    private List<Float> ShrinkAtkAdjMin;
    private List<Float> ShrinkDefAdjMax;
    private List<Float> ShrinkDefAdjMin;
    private List<Float> BlowAtkAdjMax;
    private List<Float> BlowAtkAdjMin;
    private List<Float> BlowDefAdjMax;
    private List<Float> BlowDefAdjMin;
    private List<Float> ShakeAtkAdjMax;
    private List<Float> ShakeAtkAdjMin;
    private List<Float> ShakeDefAdjMax;
    private List<Float> ShakeDefAdjMin;
    private List<Float> DownAtkAdjMax;
    private List<Float> DownAtkAdjMin;
    private List<Float> DownDefAdjMax;
    private List<Float> DownDefAdjMin;
    private List<Float> OcdAtkAdjMax;
    private List<Float> OcdAtkAdjMin;
    private List<Float> OcdDefAdjMax;
    private List<Float> OcdDefAdjMin;
    private List<Float> HpHealAtkAdjMax;
    private List<Float> HpHealAtkAdjMin;
    private List<Float> HpHealDefAdjMax;
    private List<Float> HpHealDefAdjMin;
    private List<Float> StaminaHealAtkAdjMax;
    private List<Float> StaminaHealAtkAdjMin;
    private List<Float> StaminaHealDefAdjMax;
    private List<Float> StaminaHealDefAdjMin;
    private int HolyAbsorpMax;
    private int HolyAbsorpMin;
    private float DamageMax;
    private float DamageMin;
}
