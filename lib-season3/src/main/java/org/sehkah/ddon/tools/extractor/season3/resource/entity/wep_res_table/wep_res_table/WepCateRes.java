package org.sehkah.ddon.tools.extractor.season3.resource.entity.wep_res_table.wep_res_table;

import org.sehkah.ddon.tools.extractor.lib.common.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.season3.resource.entity.base.meta.WeaponCategory;

import java.math.BigInteger;

// TODO decode information from resource IDs as meta info
public record WepCateRes(
        long Category,
        @MetaInformation
        WeaponCategory CategoryType,
        String ArcTag,
        BigInteger EffectProviderResId,
        BigInteger SoundRequestResId
) {

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
