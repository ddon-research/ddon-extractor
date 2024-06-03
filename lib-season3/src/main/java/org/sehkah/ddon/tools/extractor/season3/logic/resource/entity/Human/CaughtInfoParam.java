package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.Human;

import org.sehkah.ddon.tools.extractor.lib.common.datatype.Vector3f;
import org.sehkah.ddon.tools.extractor.lib.common.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.lib.common.util.BitUtil;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.Human.meta.CatchType;

import java.util.Set;

public record CaughtInfoParam(
        long CatchInfoType,
        @MetaInformation
        Set<CatchType> CatchTypes,
        long CaughtActionTblNo,
        Vector3f ConstOffsetPos,
        Vector3f ConstOffsetAngle
) {

    public CaughtInfoParam(long catchInfoType,
                           long caughtActionTblNo,
                           Vector3f constOffsetPos,
                           Vector3f constOffsetAngle) {
        this(catchInfoType, BitUtil.extractBitSetUnsignedIntegerFlag(CatchType::of, i -> 1 << i, catchInfoType),
                caughtActionTblNo,
                constOffsetPos,
                constOffsetAngle);
    }
}
