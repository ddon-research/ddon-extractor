package org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.tutorial_guide;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.lib.common.entity.TopLevelClientResource;
import org.sehkah.ddon.tools.extractor.lib.common.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ResourceFileLookupType;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.DynamicResourceLookupUtil;

import java.util.List;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class TutorialDialogMessage extends TopLevelClientResource {
    private long TitleGmdIdx;
    @MetaInformation
    private String TutorialTitleName;
    private long CategoryGmdIdx;
    private List<TutorialDialogMessageDialogPage> PageInfo;

    public TutorialDialogMessage(long titleGmdIdx, long categoryGmdIdx, List<TutorialDialogMessageDialogPage> pageInfo) {
        this(titleGmdIdx, DynamicResourceLookupUtil.getMessage(ResourceFileLookupType.TUTORIAL_GUIDE, "TUTORIAL_" + titleGmdIdx),
                categoryGmdIdx,
                pageInfo
        );
    }
}
