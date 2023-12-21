package org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.craft_common;

import org.sehkah.ddon.tools.extractor.lib.logic.serialization.MetaInformation;

import java.math.BigInteger;

public record CraftUpGradeExpData(
        @MetaInformation
        int Level,
        BigInteger ExpMax
) {
}
