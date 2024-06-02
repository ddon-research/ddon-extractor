package org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.season3.wep_res_table;

import org.sehkah.ddon.tools.extractor.lib.common.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.season2.base.meta.WeaponCategory;

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
