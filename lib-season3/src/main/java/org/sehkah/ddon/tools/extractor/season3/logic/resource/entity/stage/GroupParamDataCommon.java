package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.stage;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class GroupParamDataCommon {
    private int Group;
    private int Priority;
    private boolean IsDisableSplit;
    private boolean IsParts;
    private boolean HasMarkerPos;
}
