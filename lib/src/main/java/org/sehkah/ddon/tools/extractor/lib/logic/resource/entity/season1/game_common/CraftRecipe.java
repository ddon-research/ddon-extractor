package org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season1.game_common;

import org.sehkah.ddon.tools.extractor.lib.common.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season1.game_common.meta.CraftRecipeNpcAction;

import java.util.List;

public record CraftRecipe(
        long RecipeId,
        long ItemId,
        long CreateTime,
        int CreateNum,
        long Gold,
        long Exp,
        long Rank,
        int NpcAction,
        @MetaInformation
        CraftRecipeNpcAction NpcActionName,
        List<CraftRecipeMaterialData> MaterialDataList
) {
    public CraftRecipe(long recipeId, long itemId, long createTime, int createNum, long gold, long exp, long rank, int npcAction, List<CraftRecipeMaterialData> materialDataList) {
        this(recipeId, itemId, createTime, createNum, gold, exp, rank, npcAction, CraftRecipeNpcAction.of(npcAction), materialDataList);
    }
}
