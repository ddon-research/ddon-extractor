package org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.season3.stage;

import java.util.List;

public record StageCustomPartsExAreaParam(
        boolean UseAllFilter,
        int FilterNo,
        int PatternNo,
        long AreaHitShapeListNum,
        List<AreaHitShape> AreaHitShapeList
) {
    public StageCustomPartsExAreaParam(boolean useAllFilter, int filterNo, int patternNo, List<AreaHitShape> areaHitShapeList) {
        this(useAllFilter, filterNo, patternNo, areaHitShapeList.size(), areaHitShapeList);
    }
}
