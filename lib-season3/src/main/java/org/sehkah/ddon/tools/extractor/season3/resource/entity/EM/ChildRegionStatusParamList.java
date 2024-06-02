package org.sehkah.ddon.tools.extractor.season3.resource.entity.EM;

public record ChildRegionStatusParamList(
        ChildRegionStatusParamTable ChildRegion,
        long StatusNo,
        int CheckPriority,
        int WritePriority
) {
}
