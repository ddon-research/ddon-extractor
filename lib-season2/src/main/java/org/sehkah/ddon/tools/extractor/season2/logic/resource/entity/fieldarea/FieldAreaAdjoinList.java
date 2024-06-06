package org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.fieldarea;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.api.entity.TopLevelClientResource;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceFileLookupType;
import org.sehkah.ddon.tools.extractor.api.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.ResourceMetadataLookupUtilSeason2;

import java.util.List;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class FieldAreaAdjoinList extends TopLevelClientResource {
    private short FieldAreaId;
    @MetaInformation
    private String FieldAreaName;
    private List<AdjoinInfo> Array;

    public FieldAreaAdjoinList(short fieldAreaId, List<AdjoinInfo> array) {
        FieldAreaId = fieldAreaId;
        FieldAreaName = ResourceMetadataLookupUtilSeason2.getMessage(ResourceFileLookupType.FIELD_AREA_NAME, fieldAreaId - 1L);
        Array = array;
    }
}
