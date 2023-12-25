package org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.launcher;

import org.sehkah.ddon.tools.extractor.lib.logic.FrameworkResourcesUtil;
import org.sehkah.ddon.tools.extractor.lib.logic.serialization.MetaInformation;

import java.math.BigInteger;


public record ArchiveListNode(
        long SearchId,
        long TagId,
        BigInteger ResId,
        @MetaInformation
        String ResIdType,
        @MetaInformation
        long PathCRC,
        long DbgResDataNum,
        long DbgResDataPointer
) {
    public ArchiveListNode(long searchId,
                           long tagId,
                           BigInteger resId,
                           long dbgResDataNum,
                           long dbgResDataPointer) {
        this(searchId,
                tagId,
                resId, FrameworkResourcesUtil.getFrameworkResourceClassNameByCrc(resId.shiftRight(32).longValue()), resId.and(BigInteger.valueOf(0x0000_0000_ffff_ffffL)).longValue(),
                dbgResDataNum,
                dbgResDataPointer);
    }
}
