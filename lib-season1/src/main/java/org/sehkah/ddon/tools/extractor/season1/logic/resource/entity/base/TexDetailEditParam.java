package org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.base;

import org.sehkah.ddon.tools.extractor.lib.common.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.base.meta.TexDetailEditDetailType;

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
