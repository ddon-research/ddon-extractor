package org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.Human;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.lib.common.datatype.Vector3f;
import org.sehkah.ddon.tools.extractor.lib.common.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.lib.common.util.BitUtil;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.Human.meta.CatchType;

import java.util.Set;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class CaughtInfoParam {
    private long CatchInfoType;
    @MetaInformation
    private Set<CatchType> CatchTypes;
    private long CaughtActionTblNo;
    private Vector3f ConstOffsetPos;
    private Vector3f ConstOffsetAngle;

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
