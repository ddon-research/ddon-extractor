package org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.fieldarea;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.sehkah.ddon.tools.extractor.lib.common.entity.TopLevelClientResource;
import org.sehkah.ddon.tools.extractor.lib.logic.ResourceFileLookupType;
import org.sehkah.ddon.tools.extractor.lib.logic.DynamicResourceLookupUtil;
import org.sehkah.ddon.tools.extractor.lib.logic.serialization.MetaInformation;

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
