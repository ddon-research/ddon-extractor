package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.tutorial_guide;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.sehkah.ddon.tools.extractor.lib.common.entity.TopLevelClientResource;
import org.sehkah.ddon.tools.extractor.lib.common.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ResourceFileLookupType;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.DynamicResourceLookupUtil;

import java.util.List;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@RequiredArgsConstructor
@Getter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public final class TutorialDialogMessage extends TopLevelClientResource {
    private final long TitleGmdIdx;
    @MetaInformation
    private final String TutorialTitleName;
    private final long CategoryGmdIdx;
    private final List<TutorialDialogMessageDialogPage> PageInfo;

    public TutorialDialogMessage(long titleGmdIdx, long categoryGmdIdx, List<TutorialDialogMessageDialogPage> pageInfo) {
        this(titleGmdIdx, DynamicResourceLookupUtil.getMessage(ResourceFileLookupType.TUTORIAL_GUIDE, "TUTORIAL_" + titleGmdIdx),
                categoryGmdIdx,
                pageInfo
        );
    }
}
