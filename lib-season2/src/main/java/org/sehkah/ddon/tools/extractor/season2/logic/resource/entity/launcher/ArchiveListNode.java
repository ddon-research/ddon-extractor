package org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.launcher;

import org.sehkah.ddon.tools.extractor.lib.common.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.FrameworkResourcesUtil;

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
                resId, FrameworkResourcesUtil.getFrameworkResourceClassNameByCrc(FrameworkResourcesUtil.convertResourceIdToTagId(resId)), FrameworkResourcesUtil.convertResourceIdToPathId(resId),
                dbgResDataNum,
                dbgResDataPointer);
    }
}
