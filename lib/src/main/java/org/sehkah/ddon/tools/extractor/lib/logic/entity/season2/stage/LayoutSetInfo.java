package org.sehkah.ddon.tools.extractor.lib.logic.entity.season2.stage;

import org.sehkah.ddon.tools.extractor.lib.logic.entity.season2.stage.meta.LayoutSetInfoType;
import org.sehkah.ddon.tools.extractor.lib.logic.serialization.MetaInformation;

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
