package org.sehkah.ddon.tools.extractor.common.logic.resource.entity.launcher;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.api.logic.resource.FrameworkResourcesUtil;
import org.sehkah.ddon.tools.extractor.api.serialization.MetaInformation;

import java.math.BigInteger;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class ArchiveListNode {
    private long SearchId;
    private long TagId;
    private BigInteger ResId;
    @MetaInformation
    private String ResIdType;
    @MetaInformation
    private long PathCRC;
    private long DbgResDataNum;
    private long DbgResDataPointer;

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
