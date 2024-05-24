package org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.binary;

import org.sehkah.ddon.tools.extractor.lib.common.serialization.MetaInformation;

public record BinaryBody(
        @MetaInformation
        long index,
        @MetaInformation
        long bufferSizeForBody,
        @MetaInformation
        long propertyCount1, // cResource -> mQuality
        @MetaInformation
        long quality
) {

}
