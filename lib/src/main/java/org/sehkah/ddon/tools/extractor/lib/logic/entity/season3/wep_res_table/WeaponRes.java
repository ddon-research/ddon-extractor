package org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.wep_res_table;

import org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.wep_res_table.meta.WeaponSexType;
import org.sehkah.ddon.tools.extractor.lib.logic.serialization.MetaInformation;

import java.math.BigInteger;

public record WeaponRes(
        long MTag,
        String ArcTag,
        long Sex,
        @MetaInformation
        WeaponSexType SexType,
        BigInteger rModelResId,
        BigInteger rModelResId2,
        BigInteger DeformWeightMapResId,
        BigInteger EffectProviderResId,
        BigInteger SoundRequestResId,
        BigInteger DDOModelMontageResId,
        BigInteger DDOModelMontageResId2
) {
    public WeaponRes(long MTag,
                     String arcTag,
                     long sex,
                     BigInteger rModelResId,
                     BigInteger rModelResId2,
                     BigInteger deformWeightMapResId,
                     BigInteger effectProviderResId,
                     BigInteger soundRequestResId,
                     BigInteger DDOModelMontageResId,
                     BigInteger DDOModelMontageResId2) {
        this(MTag,
                arcTag,
                sex, WeaponSexType.of(sex),
                rModelResId,
                rModelResId2,
                deformWeightMapResId,
                effectProviderResId,
                soundRequestResId,
                DDOModelMontageResId,
                DDOModelMontageResId2);
    }
}
