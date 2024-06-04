package org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.stage;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class SetInfoOmRange extends SetInfo {
    private float Range;
    private long Grp;
    private boolean IsAll;
    private boolean IsOneTime;
    private SetInfoOm InfoOm;
}
