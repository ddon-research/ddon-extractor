package org.sehkah.ddon.tools.extractor.season3.resource.entity.gui_cmn;

import org.sehkah.ddon.tools.extractor.lib.common.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ResourceFileLookupType;
import org.sehkah.ddon.tools.extractor.season3.resource.DynamicResourceLookupUtil;

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
