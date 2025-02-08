package org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.tutorial_guide;

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
public class TutorialNode {
    private long Id;
    private long SortNo;
    private long TitleGmdIdx;
    @MetaInformation
    private Translation TutorialTitleName;
    private long Category;
    @MetaInformation
    private Translation CategoryName;
    private long OpenQuestId;
    @MetaInformation
    private Translation OpenQuestName;
}
