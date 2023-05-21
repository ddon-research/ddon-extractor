package org.sehkah.doon.tools.extractor.lib.logic.entity.season3.quest.meta;

import java.util.Arrays;

public enum QuestTextType {
    QUEST_TEXT_TYPE_NAME(0x0),
    QUEST_TEXT_TYPE_ORDER(0x1),
    QUEST_TEXT_TYPE_PURPOSE(0x2),
    QUEST_TEXT_TYPE_FIND_INFO(0x3),
    QUEST_TEXT_TYPE_FIND_INFO_DETAIL(0x4),
    QUEST_TEXT_TYPE_CONTENTS_DETAIL(0x5),
    QUEST_TEXT_TYPE_REWARD_NAME(0x6),
    QUEST_TEXT_TYPE_GM_INFO(0x7),
    QUEST_TEXT_TYPE_SAY_PATTERN(0x8);

    public final long value;

    QuestTextType(long value) {
        this.value = value;
    }

    public static QuestTextType of(long value) {
        return Arrays.stream(QuestTextType.values()).filter(questTextType -> questTextType.value == value).findFirst().orElse(null);
    }
}
