package org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.season3.base.meta;

import java.util.Arrays;

public enum QuestType {
    QUEST_TYPE_MAIN(0x0),
    QUEST_TYPE_SET(0x1),
    QUEST_TYPE_LIGHT(0x2),
    QUEST_TYPE_TUTORIAL(0x3),
    QUEST_TYPE_TIME_LIMITED(0x4),
    QUEST_TYPE_NUM(0x5),
    QUEST_TYPE_WORLD_SETTING(0x5),
    QUEST_TYPE_CYCLE_01(0x6),
    QUEST_TYPE_CYCLE_04(0x7),
    QUEST_TYPE_END_CONTENTS(0x8),
    QUEST_TYPE_CCYCLE_SUB_CATEGORY(0x9),
    QUEST_TYPE_PAWN(0xA),
    QUEST_TYPE_DEBUG_TOOL(0xB),
    QUEST_TYPE_MANAGER_NUM(0xC);

    public final long value;

    QuestType(long value) {
        this.value = value;
    }

    public static QuestType of(long value) {
        return Arrays.stream(QuestType.values()).filter(t -> t.value == value).findFirst().orElse(null);
    }
}
