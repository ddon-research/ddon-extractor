package org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.wep_res_table;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.api.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.wep_res_table.meta.WeaponSexType;

import java.math.BigInteger;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class WeaponRes {
    private long MTag;
    private String ArcTag;
    private long Sex;
    @MetaInformation
    private WeaponSexType SexType;
    private BigInteger ModelResId;
    private BigInteger ModelResId2;
    private BigInteger DeformWeightMapResId;
    private BigInteger EffectProviderResId;
    private BigInteger SoundRequestResId;
    private BigInteger DDOModelMontageResId;
    private BigInteger DDOModelMontageResId2;

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
