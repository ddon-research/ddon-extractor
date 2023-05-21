package org.sehkah.doon.tools.extractor.lib.logic.entity.season3.craft_common;

import org.sehkah.doon.tools.extractor.lib.common.entity.DeserializableClientResource;

public record CraftCapPassData(
        long RecipeId,
        int StartLv,
        int LvCap,
        int Ver,
        int Round,
        int Type
) implements DeserializableClientResource {
}
