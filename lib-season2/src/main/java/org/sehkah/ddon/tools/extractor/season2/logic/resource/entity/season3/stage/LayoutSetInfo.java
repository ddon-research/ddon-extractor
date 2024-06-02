package org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.season3.stage;

import org.sehkah.ddon.tools.extractor.lib.common.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.season3.stage.meta.LayoutSetInfoType;

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
