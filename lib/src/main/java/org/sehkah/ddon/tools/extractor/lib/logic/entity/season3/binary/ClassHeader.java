package org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.binary;

import java.util.List;

public record ClassHeader(
        long numClasses,
        long bufferSizeForHeader,
        List<Long> classDataOffsets,
        List<ClassData> classDataList
) {
}
