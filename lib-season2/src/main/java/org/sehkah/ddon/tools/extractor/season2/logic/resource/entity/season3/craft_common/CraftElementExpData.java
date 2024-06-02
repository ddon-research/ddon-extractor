package org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.season3.craft_common;

import org.sehkah.ddon.tools.extractor.lib.common.serialization.MetaInformation;

import java.math.BigInteger;

public record CraftElementExpData(
        @MetaInformation
        int Level,
        BigInteger Exp,
        long Price
) {
}
