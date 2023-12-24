package org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.EM;

import org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.EM.meta.BitCommandType;
import org.sehkah.ddon.tools.extractor.lib.logic.serialization.MetaInformation;

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
