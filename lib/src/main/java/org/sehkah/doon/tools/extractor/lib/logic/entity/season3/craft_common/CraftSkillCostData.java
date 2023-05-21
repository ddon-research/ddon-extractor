package org.sehkah.doon.tools.extractor.lib.logic.entity.season3.craft_common;

import org.sehkah.doon.tools.extractor.lib.common.entity.DeserializableClientResource;

public record CraftSkillCostData(
        long Total,
        float CostRate1,
        float CostRate2,
        float CostRate3,
        float CostRate4
) implements DeserializableClientResource {
}
