package org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.wep_res_table;

import org.sehkah.ddon.tools.extractor.lib.logic.entity.season2.base.meta.WeaponCategory;
import org.sehkah.ddon.tools.extractor.lib.logic.serialization.MetaInformation;

import java.math.BigInteger;

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
