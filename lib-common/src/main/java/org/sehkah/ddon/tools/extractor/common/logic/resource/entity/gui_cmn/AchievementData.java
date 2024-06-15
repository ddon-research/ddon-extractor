package org.sehkah.ddon.tools.extractor.common.logic.resource.entity.gui_cmn;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.api.logic.resource.Translation;
import org.sehkah.ddon.tools.extractor.api.serialization.MetaInformation;

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
    private Translation AchievementName;
    @MetaInformation
    private Translation AchievementInfo;
    private int Category;
    @MetaInformation
    private Translation AchievementCategoryName;
    private int Trophy;
}
