package org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.season3.EM;

public record ChildRegionStatusParamList(
        ChildRegionStatusParamTable ChildRegion,
        long StatusNo,
        int CheckPriority,
        int WritePriority
) {
}
