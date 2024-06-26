package org.sehkah.ddon.tools.extractor.common.logic.resource.entity.craft_common;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.api.serialization.MetaInformation;

import java.math.BigInteger;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class CraftElementExpData {
    @MetaInformation
    private int Level;
    private BigInteger Exp;
    private long Price;
}
