package org.sehkah.ddon.tools.extractor.common.logic.resource.entity.EM;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;

import java.math.BigInteger;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class ReactionCondition {
    private long Condition;
    private BigInteger Param0;
    private BigInteger Param1;
    private long CkAndOR;
    private boolean Reverse;
}
