package org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.gui_cmn;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.lib.common.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ResourceFileLookupType;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.DynamicResourceLookupUtil;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class AchievementData {
    private long ID;
    private long TargetNum;
    private long MessageIndex;
    @MetaInformation
    private String AchievementName;
    @MetaInformation
    private String AchievementInfo;
    private int Category;
    @MetaInformation
    private String AchievementCategoryName;
    private int Trophy;

    public AchievementData(long ID, long targetNum, long messageIndex, int category, int trophy) {
        this(ID,
                targetNum,
                messageIndex, DynamicResourceLookupUtil.getMessage(ResourceFileLookupType.ACHIEVEMENT_NAME, messageIndex), DynamicResourceLookupUtil.getMessage(ResourceFileLookupType.ACHIEVEMENT_INFO, messageIndex),
                category, DynamicResourceLookupUtil.getMessage(ResourceFileLookupType.ACHIEVEMENT_CATEGORY, "ACHIEVEMENT_CATEGORY_" + category),
                trophy);
    }
}
