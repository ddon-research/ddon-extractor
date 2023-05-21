package org.sehkah.doon.tools.extractor.lib.logic.entity.season3.craft_common;

import org.sehkah.doon.tools.extractor.lib.common.entity.DeserializableClientResource;
import org.sehkah.doon.tools.extractor.lib.logic.serialization.MetaInformation;

import java.math.BigInteger;

public record CraftElementExpData(
        @MetaInformation
        int Level,
        BigInteger Exp,
        long Price
) implements DeserializableClientResource {
}
