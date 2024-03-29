package org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.Human;

import org.sehkah.ddon.tools.extractor.lib.common.datatype.Vector3f;
import org.sehkah.ddon.tools.extractor.lib.common.util.BitUtil;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.Human.meta.CatchType;
import org.sehkah.ddon.tools.extractor.lib.logic.serialization.MetaInformation;

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
