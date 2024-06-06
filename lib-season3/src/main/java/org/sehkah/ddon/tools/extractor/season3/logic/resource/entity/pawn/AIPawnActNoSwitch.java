package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.pawn;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.api.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.api.util.BitUtil;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.pawn.meta.AIPawnActionSwitchType;

import java.util.List;
import java.util.Set;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class AIPawnActNoSwitch {
    private long EmActNo;
    private long PwActNo;
    private List<Long> PwActSwTypeFlag;
    @MetaInformation
    private Set<AIPawnActionSwitchType> PwActSwTypeFlagTypes;

    public AIPawnActNoSwitch(
            long EmActNo,
            long PwActNo,
            List<Long> PwActSwTypeFlag
    ) {
        this(
                EmActNo,
                PwActNo,
                PwActSwTypeFlag, BitUtil.extractBitSetUnsignedIntegerFlag(AIPawnActionSwitchType::of, PwActSwTypeFlag, 6)
        );
    }
}
