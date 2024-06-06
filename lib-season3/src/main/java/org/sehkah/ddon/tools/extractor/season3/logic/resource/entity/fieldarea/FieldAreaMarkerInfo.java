package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.fieldarea;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.api.entity.TopLevelClientResource;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceFileLookupType;
import org.sehkah.ddon.tools.extractor.api.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.ResourceMetadataLookupUtilSeason3;

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
        FieldAreaName = ResourceMetadataLookupUtilSeason3.getMessage(ResourceFileLookupType.FIELD_AREA_NAME, fieldAreaId - 1);
        MarkerInfoArray = markerInfoArray;
    }
}
