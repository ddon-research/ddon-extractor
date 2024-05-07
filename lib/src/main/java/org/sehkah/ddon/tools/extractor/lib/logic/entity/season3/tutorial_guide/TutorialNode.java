package org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.tutorial_guide;

import org.sehkah.ddon.tools.extractor.lib.logic.DynamicResourceLookupUtil;
import org.sehkah.ddon.tools.extractor.lib.logic.ResourceFileLookupType;
import org.sehkah.ddon.tools.extractor.lib.logic.serialization.MetaInformation;

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
