package org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.binary;

import java.util.Map;

public record XfsHeader(
        int resourceVersion,
        long objectDataNum,
        int classIndex,
        int objIndex,
        ClassHeader classHeader,
        Map<Integer, ClassData> classHeaderIndex
) {

}
