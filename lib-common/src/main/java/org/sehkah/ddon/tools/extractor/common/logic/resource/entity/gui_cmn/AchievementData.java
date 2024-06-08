package org.sehkah.ddon.tools.extractor.common.logic.resource.entity.gui_cmn;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
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
    private String AchievementName;
    @MetaInformation
    private String AchievementInfo;
    private int Category;
    @MetaInformation
    private String AchievementCategoryName;
    private int Trophy;
}
