package org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.tutorial_guide;

import org.sehkah.ddon.tools.extractor.lib.logic.MessageFileLookupType;
import org.sehkah.ddon.tools.extractor.lib.logic.MessageLookupUtil;
import org.sehkah.ddon.tools.extractor.lib.logic.serialization.MetaInformation;

public record TutorialNode(
        long Id,
        long SortNo,
        long TitleGmdIdx,
        @MetaInformation
        String TutorialTitleName,
        long Category,
        long OpenQuestId,
        boolean UnknownBoolean
) {
    public TutorialNode(long id, long sortNo, long titleGmdIdx, long category, long openQuestId, boolean unknownBoolean) {
        this(id,
                sortNo,
                titleGmdIdx, MessageLookupUtil.getMessage(MessageFileLookupType.TUTORIAL_GUIDE, titleGmdIdx),
                category,
                openQuestId,
                unknownBoolean);
    }
}
