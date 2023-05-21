package org.sehkah.doon.tools.extractor.lib.logic.entity.season3.ui.uGUISkill;

import org.sehkah.doon.tools.extractor.lib.common.entity.DeserializableClientResource;

import java.util.List;

public record AbilityAddData(
        int Id,
        int SortCategory,
        List<AbilityLevelData> LvArray
) implements DeserializableClientResource {
}
