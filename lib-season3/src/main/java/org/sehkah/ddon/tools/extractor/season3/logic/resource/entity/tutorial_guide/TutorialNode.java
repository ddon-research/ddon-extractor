package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.tutorial_guide;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.lib.common.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ResourceFileLookupType;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.DynamicResourceLookupUtil;

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
    @MetaInformation
    private String CategoryName;
    private long OpenQuestId;
    private boolean UnknownBoolean;

    public TutorialNode(long id, long sortNo, long titleGmdIdx, long category, long openQuestId, boolean unknownBoolean) {
        this(id,
                sortNo,
                titleGmdIdx, DynamicResourceLookupUtil.getMessage(ResourceFileLookupType.TUTORIAL_GUIDE, titleGmdIdx),
                category, DynamicResourceLookupUtil.getMessage(ResourceFileLookupType.TUTORIAL_GUIDE_CATEGORY, category),
                openQuestId,
                unknownBoolean);
    }
}
