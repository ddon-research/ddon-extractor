package org.sehkah.ddon.tools.extractor.season3.resource.entity.ui.uGUISkill;

import java.util.List;

public record AbilityAddData(
        int Id,
        int SortCategory,
        List<AbilityLevelData> LvArray
) {
}
