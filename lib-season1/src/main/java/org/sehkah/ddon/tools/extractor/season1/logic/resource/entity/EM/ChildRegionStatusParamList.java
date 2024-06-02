package org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.EM;

public record ChildRegionStatusParamList(
        ChildRegionStatusParamTable ChildRegion,
        long StatusNo,
        int CheckPriority,
        int WritePriority
) {
}
