package org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.game_common.meta;

import java.util.Arrays;

public enum CraftRecipeNpcAction {
    NPC_ACTION_NONE(0x0),
    NPC_ACTION_STITHY(0x1),
    NPC_ACTION_DESK(0x2),
    NPC_ACTION_COOK(0x3);

    public final long value;

    CraftRecipeNpcAction(long value) {
        this.value = value;
    }

    public static CraftRecipeNpcAction of(long value) {
        return Arrays.stream(CraftRecipeNpcAction.values()).filter(t -> t.value == value).findFirst().orElse(null);
    }
}
