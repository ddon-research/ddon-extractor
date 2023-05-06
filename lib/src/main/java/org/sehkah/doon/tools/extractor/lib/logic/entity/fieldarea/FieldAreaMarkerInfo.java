package org.sehkah.doon.tools.extractor.lib.logic.entity.fieldarea;

import java.util.List;

public record FieldAreaMarkerInfo(
        long FieldAreaId,
        List<MarkerInfo> MarkerInfoArray
) {
}
