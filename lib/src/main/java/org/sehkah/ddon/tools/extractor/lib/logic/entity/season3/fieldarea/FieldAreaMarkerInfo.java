package org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.fieldarea;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.sehkah.ddon.tools.extractor.lib.common.entity.TopLevelClientResource;
import org.sehkah.ddon.tools.extractor.lib.logic.DynamicResourceLookupUtil;
import org.sehkah.ddon.tools.extractor.lib.logic.ResourceFileLookupType;
import org.sehkah.ddon.tools.extractor.lib.logic.serialization.MetaInformation;

import java.util.List;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@RequiredArgsConstructor
@Getter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public final class FieldAreaMarkerInfo extends TopLevelClientResource {
    private final long FieldAreaId;
    @MetaInformation
    private final String FieldAreaName;
    private final List<MarkerInfo> MarkerInfoArray;

    public FieldAreaMarkerInfo(long fieldAreaId, List<MarkerInfo> markerInfoArray) {
        FieldAreaId = fieldAreaId;
        FieldAreaName = DynamicResourceLookupUtil.getMessage(ResourceFileLookupType.FIELD_AREA_NAME, fieldAreaId - 1);
        MarkerInfoArray = markerInfoArray;
    }
}
