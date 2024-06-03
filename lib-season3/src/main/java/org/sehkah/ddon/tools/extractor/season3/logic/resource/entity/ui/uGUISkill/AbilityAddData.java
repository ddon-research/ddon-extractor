package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.ui.uGUISkill;

import java.util.List;

public record AbilityAddData(
        int Id,
        int SortCategory,
        List<AbilityLevelData> LvArray
) {
}
