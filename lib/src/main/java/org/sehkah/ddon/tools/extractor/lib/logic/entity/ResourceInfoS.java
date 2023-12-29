package org.sehkah.ddon.tools.extractor.lib.logic.entity;

import org.sehkah.ddon.tools.extractor.lib.logic.FrameworkResourcesUtil;
import org.sehkah.ddon.tools.extractor.lib.logic.serialization.MetaInformation;

import java.math.BigInteger;

public record ResourceInfoS(
        BigInteger ResourceID,
        long Type,
        @MetaInformation
        String TypeName,
        @MetaInformation
        long PathCRC
) {
    public ResourceInfoS(BigInteger ResourceID, long Type) {
        this(
                ResourceID,
                Type, FrameworkResourcesUtil.getFrameworkResourceClassNameByCrc(Type),
                FrameworkResourcesUtil.convertResourceIdToPathId(ResourceID)
        );
    }
}
