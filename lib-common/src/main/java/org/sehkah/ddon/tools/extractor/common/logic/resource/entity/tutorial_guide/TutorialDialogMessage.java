package org.sehkah.ddon.tools.extractor.common.logic.resource.entity.tutorial_guide;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.api.entity.Resource;
import org.sehkah.ddon.tools.extractor.api.logic.resource.Translation;
import org.sehkah.ddon.tools.extractor.api.serialization.MetaInformation;

import java.util.List;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class TutorialDialogMessage extends Resource {
    private long TitleGmdIdx;
    @MetaInformation
    private Translation TutorialTitleName;
    private long CategoryGmdIdx;
    private List<TutorialDialogMessageDialogPage> PageInfo;
}
