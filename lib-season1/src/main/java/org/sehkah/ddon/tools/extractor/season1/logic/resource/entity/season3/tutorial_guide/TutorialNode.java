package org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.season3.tutorial_guide;

import org.sehkah.ddon.tools.extractor.lib.common.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ResourceFileLookupType;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.DynamicResourceLookupUtil;

public record TutorialNode(
        long Id,
        long SortNo,
        long TitleGmdIdx,
        @MetaInformation
        String TutorialTitleName,
        long Category,
        @MetaInformation
        String CategoryName,
        long OpenQuestId,
        boolean UnknownBoolean
) {
    public TutorialNode(long id, long sortNo, long titleGmdIdx, long category, long openQuestId, boolean unknownBoolean) {
        this(id,
                sortNo,
                titleGmdIdx, DynamicResourceLookupUtil.getMessage(ResourceFileLookupType.TUTORIAL_GUIDE, titleGmdIdx),
                category, DynamicResourceLookupUtil.getMessage(ResourceFileLookupType.TUTORIAL_GUIDE_CATEGORY, category),
                openQuestId,
                unknownBoolean);
    }
}
