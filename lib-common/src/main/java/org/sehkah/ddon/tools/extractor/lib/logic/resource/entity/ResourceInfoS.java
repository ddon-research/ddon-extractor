package org.sehkah.ddon.tools.extractor.lib.logic.resource.entity;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.lib.common.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.FrameworkResourcesUtil;

import java.math.BigInteger;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public final class ResourceInfoS {
    private BigInteger ResourceID;
    private long Type;
    @MetaInformation
    private String TypeName;
    @MetaInformation
    private long PathCRC;

    public ResourceInfoS(BigInteger ResourceID, long Type) {
        this(
                ResourceID,
                Type, FrameworkResourcesUtil.getFrameworkResourceClassNameByCrc(Type),
                FrameworkResourcesUtil.convertResourceIdToPathId(ResourceID)
        );
    }
}
