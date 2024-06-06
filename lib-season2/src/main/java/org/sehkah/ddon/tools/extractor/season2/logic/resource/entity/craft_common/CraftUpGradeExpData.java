package org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.craft_common;

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
public class CraftUpGradeExpData {
    @MetaInformation
    private int Level;
    private BigInteger ExpMax;
}
