package org.sehkah.ddon.tools.extractor.lib.logic.resource.entity;

import org.sehkah.ddon.tools.extractor.lib.common.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.FrameworkResourcesUtil;

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
