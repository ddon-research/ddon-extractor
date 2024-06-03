package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.fieldarea;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.lib.common.entity.TopLevelClientResource;
import org.sehkah.ddon.tools.extractor.lib.common.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ResourceFileLookupType;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.DynamicResourceLookupUtil;

import java.util.List;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class FieldAreaMarkerInfo extends TopLevelClientResource {
    private long FieldAreaId;
    @MetaInformation
    private String FieldAreaName;
    private List<MarkerInfo> MarkerInfoArray;

    public FieldAreaMarkerInfo(long fieldAreaId, List<MarkerInfo> markerInfoArray) {
        FieldAreaId = fieldAreaId;
        FieldAreaName = DynamicResourceLookupUtil.getMessage(ResourceFileLookupType.FIELD_AREA_NAME, fieldAreaId - 1);
        MarkerInfoArray = markerInfoArray;
    }
}
