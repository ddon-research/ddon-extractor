package org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.craft_common;

import org.sehkah.ddon.tools.extractor.lib.common.serialization.MetaInformation;

import java.math.BigInteger;

public record CraftUpGradeExpData(
        @MetaInformation
        int Level,
        BigInteger ExpMax
) {
}