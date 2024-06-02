package org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.season3.binary;

import java.util.List;

public record ClassHeader(
        long numClasses,
        long bufferSizeForHeader,
        List<Long> classDataOffsets,
        List<ClassData> classDataList
) {
}
