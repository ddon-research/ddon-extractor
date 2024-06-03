package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.stage;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class SetInfoOmUnknown30 extends SetInfo {
    private long UnknownStageNo; // TODO Not sure if this is really a stage no
    private long Unknown1;
    private long QuestId;
    private long Unknown2;
    private SetInfoOmOld InfoOm;
}
