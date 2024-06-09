package org.sehkah.ddon.tools.extractor.common.logic.resource.entity;

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
