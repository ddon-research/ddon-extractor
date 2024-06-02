package org.sehkah.ddon.tools.extractor.season3.resource.entity.base;

import org.sehkah.ddon.tools.extractor.lib.common.serialization.MetaInformation;

public record LayoutPreset(
        @MetaInformation
        int PresetKind,
        String Keyword,
        long CtrlType,
        long EnemyId
) {
}
