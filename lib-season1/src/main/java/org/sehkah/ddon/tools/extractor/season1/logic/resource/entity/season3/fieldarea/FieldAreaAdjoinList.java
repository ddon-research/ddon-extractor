package org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.season3.fieldarea;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.sehkah.ddon.tools.extractor.lib.common.entity.TopLevelClientResource;
import org.sehkah.ddon.tools.extractor.lib.common.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ResourceFileLookupType;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.DynamicResourceLookupUtil;

import java.util.List;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@RequiredArgsConstructor
@Getter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public final class FieldAreaAdjoinList extends TopLevelClientResource {
    private final short FieldAreaId;
    @MetaInformation
    private final String FieldAreaName;
    private final List<AdjoinInfo> Array;

    public FieldAreaAdjoinList(short fieldAreaId, List<AdjoinInfo> array) {
        FieldAreaId = fieldAreaId;
        FieldAreaName = DynamicResourceLookupUtil.getMessage(ResourceFileLookupType.FIELD_AREA_NAME, fieldAreaId - 1L);
        Array = array;
    }
}
