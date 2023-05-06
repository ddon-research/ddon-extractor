package org.sehkah.doon.tools.extractor.lib.logic.entity.craft_common;

public record CraftCapPassData(
        long RecipeId,
        int StartLv,
        int LvCap,
        int Ver,
        int Round,
        int Type
) {
}
