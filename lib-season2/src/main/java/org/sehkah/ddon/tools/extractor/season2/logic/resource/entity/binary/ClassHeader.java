package org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.binary;

import java.util.List;

public record ClassHeader(
        long numClasses,
        long bufferSizeForHeader,
        List<Long> classDataOffsets,
        List<ClassData> classDataList
) {
}
