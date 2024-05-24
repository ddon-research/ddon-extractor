package org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.base;

import org.sehkah.ddon.tools.extractor.lib.common.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.base.meta.TexDetailEditDetailType;

public record TexDetailEditParam(
        String Path,
        long Form,
        long Type,
        @MetaInformation
        TexDetailEditDetailType TypeName
) {
    public TexDetailEditParam(String path, long form, long type) {
        this(
                path,
                form,
                type, TexDetailEditDetailType.of(type)
        );
    }
}
