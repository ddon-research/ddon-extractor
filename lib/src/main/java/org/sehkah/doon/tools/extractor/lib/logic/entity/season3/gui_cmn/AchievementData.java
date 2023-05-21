package org.sehkah.doon.tools.extractor.lib.logic.entity.season3.gui_cmn;

import org.sehkah.doon.tools.extractor.lib.common.entity.DeserializableClientResource;

public record AchievementData(
        long ID,
        long TargetNum,
        long MessageIndex,
        int Category,
        int Trophy
) implements DeserializableClientResource {
}
