package org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.pawn;

import org.sehkah.ddon.tools.extractor.lib.common.util.BitUtil;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.pawn.meta.AIPawnActionSwitchType;
import org.sehkah.ddon.tools.extractor.lib.logic.serialization.MetaInformation;

import java.util.List;
import java.util.Set;


public record AIPawnActNoSwitch(
        long EmActNo,
        long PwActNo,
        // cPwActSwTypeFlag == cBitSet<6> / u32 mBit[1]
        List<Long> PwActSwTypeFlag,
        @MetaInformation
        Set<AIPawnActionSwitchType> PwActSwTypeFlagTypes
) {
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
