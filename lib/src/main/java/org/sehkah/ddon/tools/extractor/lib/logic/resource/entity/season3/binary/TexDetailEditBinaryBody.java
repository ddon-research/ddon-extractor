package org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.binary;

import org.sehkah.ddon.tools.extractor.lib.common.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.base.TexDetailEditParam;

import java.util.List;

public record TexDetailEditBinaryBody(
        @MetaInformation
        long index,
        @MetaInformation
        long bufferSizeForBody,
        @MetaInformation
        long unknown1,
        @MetaInformation
        long unknown2,
        @MetaInformation
        long unknown3,
        @MetaInformation
        int index1,
        @MetaInformation
        int index2,
        @MetaInformation
        long bufferSize2,
        @MetaInformation
        long count2,
        @MetaInformation
        boolean autoDelete, // MtArray
        @MetaInformation
        long length, // MtArray
        List<TexDetailEditParam> EditList
) {

}
