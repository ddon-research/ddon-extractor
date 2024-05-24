package org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.binary;

public record BinaryHeader(
        int version,
        long objectDataNum,
        long index,
        ClassHeader classHeader
) {

}
