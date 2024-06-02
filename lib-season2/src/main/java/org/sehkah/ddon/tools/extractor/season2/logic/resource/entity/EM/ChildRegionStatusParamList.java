package org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.EM;

public record ChildRegionStatusParamList(
        ChildRegionStatusParamTable ChildRegion,
        long StatusNo,
        int CheckPriority,
        int WritePriority
) {
}
