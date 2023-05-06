package org.sehkah.doon.tools.extractor.lib.logic.entity.fieldarea;

import java.util.List;

public record FieldAreaAdjoinList(
        short FieldAreaId,
        List<AdjoinInfo> Array
) {
}
