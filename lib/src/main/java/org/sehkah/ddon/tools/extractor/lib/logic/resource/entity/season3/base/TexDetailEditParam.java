package org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.base;

import org.sehkah.ddon.tools.extractor.lib.common.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.base.meta.TexDetailEditDetailType;

public record TexDetailEditParam(
        @MetaInformation
        int index1,
        @MetaInformation
        int index2,
        @MetaInformation
        long bufferSize,
        @MetaInformation
        long count,
        // rTexDetailParam - begin
        String Path,
        long Form,
        long Type,
        @MetaInformation
        TexDetailEditDetailType TypeName,
        //u32 mIgnoreLimit; //not part of PropertyList in season 2
        // rTexDetailParam - end
        @MetaInformation
        long unknown1,
        @MetaInformation
        long unknown2
) {

    public TexDetailEditParam(int index1, int index2, long bufferSize, long count, String path, long form,
                              long type, long unknown1, long unknown2) {
        this(index1, index2, bufferSize, count, path, form,
                type, TexDetailEditDetailType.of(type),
                unknown1, unknown2);
    }
}
