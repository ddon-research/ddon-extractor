package org.sehkah.doon.tools.extractor.lib.logic.entity.ui.uGUISkill;

import java.util.List;

public record AbilityAddData(
        int Id,
        int SortCategory,
        List<AbilityLevelData> LvArray
) {
}
