package org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.gui_cmn;

import org.sehkah.ddon.tools.extractor.lib.logic.MessageFileLookupType;
import org.sehkah.ddon.tools.extractor.lib.logic.MessageLookupUtil;
import org.sehkah.ddon.tools.extractor.lib.logic.serialization.MetaInformation;

public record AchievementData(
        long ID,
        long TargetNum,
        long MessageIndex,
        @MetaInformation
        String AchievementName,
        @MetaInformation
        String AchievementInfo,
        int Category,
        @MetaInformation
        String AchievementCategoryName,
        int Trophy
) {
    public AchievementData(long ID, long targetNum, long messageIndex, int category, int trophy) {
        this(ID,
                targetNum,
                messageIndex, MessageLookupUtil.getMessage(MessageFileLookupType.ACHIEVEMENT_NAME, messageIndex), MessageLookupUtil.getMessage(MessageFileLookupType.ACHIEVEMENT_INFO, messageIndex),
                category, MessageLookupUtil.getMessage(MessageFileLookupType.ACHIEVEMENT_CATEGORY, "ACHIEVEMENT_CATEGORY_" + category),
                trophy);
    }
}
