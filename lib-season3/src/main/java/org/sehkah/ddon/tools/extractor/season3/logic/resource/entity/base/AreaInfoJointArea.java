package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.base;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.lib.common.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ResourceFileLookupType;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.DynamicResourceLookupUtil;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class AreaInfoJointArea {
    private long MAJAId;
    private long AreaId;
    @MetaInformation
    private String AreaName;

    public AreaInfoJointArea(long MAJAId, long areaId) {
        this(MAJAId,
                areaId, DynamicResourceLookupUtil.getMessage(ResourceFileLookupType.AREA_LIST, areaId - 1));
    }
}
