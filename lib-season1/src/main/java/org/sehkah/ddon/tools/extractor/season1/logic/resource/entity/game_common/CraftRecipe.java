package org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.game_common;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.lib.common.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.game_common.meta.CraftRecipeNpcAction;

import java.util.List;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class CraftRecipe {
    private long RecipeId;
    private long ItemId;
    private long CreateTime;
    private int CreateNum;
    private long Gold;
    private long Exp;
    private long Rank;
    private int NpcAction;
    @MetaInformation
    private CraftRecipeNpcAction NpcActionName;
    private List<CraftRecipeMaterialData> MaterialDataList;

    public CraftRecipe(long recipeId, long itemId, long createTime, int createNum, long gold, long exp, long rank, int npcAction, List<CraftRecipeMaterialData> materialDataList) {
        this(recipeId, itemId, createTime, createNum, gold, exp, rank, npcAction, CraftRecipeNpcAction.of(npcAction), materialDataList);
    }
}
