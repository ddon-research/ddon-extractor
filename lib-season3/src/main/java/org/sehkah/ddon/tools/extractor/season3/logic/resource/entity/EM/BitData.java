package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.EM;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.lib.common.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.EM.meta.BitCommandType;

import java.math.BigInteger;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class BitData {
    private BigInteger BitData;
    private long CommandType;
    @MetaInformation
    private BitCommandType CommandTypeName;

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
