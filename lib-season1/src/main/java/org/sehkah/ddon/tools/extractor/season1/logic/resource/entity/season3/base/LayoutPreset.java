package org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.season3.base;

import org.sehkah.ddon.tools.extractor.lib.common.serialization.MetaInformation;

public record LayoutPreset(
        @MetaInformation
        int PresetKind,
        String Keyword,
        long CtrlType,
        long EnemyId
) {
}
