package org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.ui.uGUISkill;

import java.util.List;

public record AbilityAddData(
        int Id,
        int SortCategory,
        List<AbilityLevelData> LvArray
) {
}
