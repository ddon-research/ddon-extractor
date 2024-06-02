package org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.stage;

import org.sehkah.ddon.tools.extractor.lib.common.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.stage.meta.LayoutSetInfoType;

public record LayoutSetInfo(
        int ID,
        long Type,
        @MetaInformation
        LayoutSetInfoType TypeName,
        SetInfo Info
) {

    public LayoutSetInfo(int ID, long type, SetInfo info) {
        this(ID,
                type, LayoutSetInfoType.of(type),
                info);
    }
}
