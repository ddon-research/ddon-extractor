package org.sehkah.doon.tools.extractor.lib.logic.entity.season3.fieldarea;

import org.sehkah.doon.tools.extractor.lib.common.entity.TopLevelClientResource;

import java.util.List;

public record FieldAreaMarkerInfo(
        long FieldAreaId,
        List<MarkerInfo> MarkerInfoArray
) implements TopLevelClientResource {
}
