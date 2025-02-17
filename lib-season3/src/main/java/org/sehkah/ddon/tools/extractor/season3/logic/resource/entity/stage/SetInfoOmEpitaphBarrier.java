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
public class SetInfoOmEpitaphBarrier extends SetInfo {
    private long unknown1;
    private boolean unknown2;
    private int unknown3;
    private boolean unknown4;
    private SetInfoOmOld InfoOm;
}
