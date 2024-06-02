package org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.EM;

import org.sehkah.ddon.tools.extractor.lib.common.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.EM.meta.BitCommandType;

import java.math.BigInteger;

public record BitData(
        BigInteger BitData,
        long CommandType,
        @MetaInformation
        BitCommandType CommandTypeName
) {
    public BitData(
            BigInteger BitData,
            long CommandType
    ) {
        this(
                BitData,
                CommandType, BitCommandType.of(CommandType)
        );
    }
}
