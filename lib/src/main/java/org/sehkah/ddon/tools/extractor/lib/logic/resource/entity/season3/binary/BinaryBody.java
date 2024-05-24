package org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.binary;

import org.sehkah.ddon.tools.extractor.lib.common.serialization.MetaInformation;

import java.util.List;

public record BinaryBody<T>(
        @MetaInformation
        long index,
        @MetaInformation
        long bufferSizeForBody,
        @MetaInformation
        long propertyCount1, // cResource -> mQuality
        @MetaInformation
        long quality,
        @MetaInformation
        long propertyCount2, // rTexDetailEdit -> mEditList
        @MetaInformation
        int index1,
        @MetaInformation
        int propertyIndex,
        @MetaInformation
        long bufferSize2,
        @MetaInformation
        long propertyCount3, // MtArray -> mAutoDelete
        @MetaInformation
        boolean autoDelete,
        @MetaInformation
        long length,
        List<T> Data
) {

}
