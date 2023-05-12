package org.sehkah.doon.tools.extractor.lib.logic.entity.EM;

public record EmLvUpParam(
        long Lv,
        float[] Hp_Cor,
        float[] ShP_Cor,
        float[] BlP_Cor,
        float Ocd_Cor,
        float AttackWepPhys_Cor,
        float AttackWepMagic_Cor,
        float DefenceWepPhys_Cor,
        float DefenceWepMagic_Cor,
        float AttackBasePhys_Cor,
        float AttackBaseMagic_Cor,
        float DefenceBasePhys_Cor,
        float DefenceBaseMagic_Cor,
        float Power_Cor,
        float GuardDefBase_Cor,
        float GuardDefWep_Cor,
        float DownP_Cor,
        float ShakeP_Cor
) {
}
