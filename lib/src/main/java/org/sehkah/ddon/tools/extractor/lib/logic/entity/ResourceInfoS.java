package org.sehkah.ddon.tools.extractor.lib.logic.entity;

import org.sehkah.ddon.tools.extractor.lib.logic.FrameworkResources;
import org.sehkah.ddon.tools.extractor.lib.logic.serialization.MetaInformation;

import java.math.BigInteger;

public record ResourceInfoS(
        BigInteger ResourceID,
        long Type,
        @MetaInformation
        String TypeName,
        // FIXME: Find a way to decode this into the original path
        @MetaInformation
        long PathCRC
) {
    public ResourceInfoS(BigInteger reference, long typeId) {
        this(
                reference,
                typeId, FrameworkResources.getFrameworkResourceClassNameByCrc(typeId),
                reference.and(BigInteger.valueOf(0x0000_0000_ffff_ffffL)).longValue()
        );
    }
}
