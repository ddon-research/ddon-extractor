package org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.gui_cmn;

import org.sehkah.ddon.tools.extractor.lib.logic.ResourceFileLookupType;
import org.sehkah.ddon.tools.extractor.lib.logic.DynamicResourceLookupUtil;
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
                messageIndex, DynamicResourceLookupUtil.getMessage(ResourceFileLookupType.ACHIEVEMENT_NAME, messageIndex), DynamicResourceLookupUtil.getMessage(ResourceFileLookupType.ACHIEVEMENT_INFO, messageIndex),
                category, DynamicResourceLookupUtil.getMessage(ResourceFileLookupType.ACHIEVEMENT_CATEGORY, "ACHIEVEMENT_CATEGORY_" + category),
                trophy);
    }
}
