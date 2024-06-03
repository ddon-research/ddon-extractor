package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.craft_common;

import org.sehkah.ddon.tools.extractor.lib.common.serialization.MetaInformation;

import java.math.BigInteger;

public record CraftUpGradeExpData(
        @MetaInformation
        int Level,
        BigInteger ExpMax
) {
}
