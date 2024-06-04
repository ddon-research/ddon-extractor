package org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.tutorial_guide;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class TutorialDialogMessageDialogPage {
    // TODO: Corresponds to the gmd "next to" this file, but requires memorizing the file names
    private long TextGmdIdx;
    private long ImageId;
}
