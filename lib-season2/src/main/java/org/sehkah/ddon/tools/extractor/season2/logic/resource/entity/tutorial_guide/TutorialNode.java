package org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.tutorial_guide;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceFileLookupType;
import org.sehkah.ddon.tools.extractor.api.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.ResourceMetadataLookupUtilSeason2;

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
    private String TutorialTitleName;
    private long Category;
    private long OpenQuestId;

    public TutorialNode(long id, long sortNo, long titleGmdIdx, long category, long openQuestId) {
        this(id,
                sortNo,
                titleGmdIdx, ResourceMetadataLookupUtilSeason2.getMessage(ResourceFileLookupType.TUTORIAL_GUIDE, titleGmdIdx),
                category,
                openQuestId);
    }
}
