package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.wep_res_table;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.api.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.base.meta.WeaponCategory;

import java.math.BigInteger;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
// TODO decode information from resource IDs as meta info
public class WepCateRes {
    private long Category;
    @MetaInformation
    private WeaponCategory CategoryType;
    private String ArcTag;
    private BigInteger EffectProviderResId;
    private BigInteger SoundRequestResId;

    public WepCateRes(long category,
                      String arcTag,
                      BigInteger effectProviderId,
                      BigInteger soundRequestId) {
        this(category, WeaponCategory.of(category),
                arcTag,
                effectProviderId,
                soundRequestId);
    }
}
