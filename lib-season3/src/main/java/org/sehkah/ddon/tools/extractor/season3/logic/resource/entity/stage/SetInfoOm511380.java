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
// Barrier in Epitaph Road
public class SetInfoOm511380 extends SetInfo {
    private boolean Block;
    // TODO: Lookup
    private long Kind;
    private long Grp;
    private int ID;
    //Circle with line
    private boolean MapIcon;
    private SetInfoOmOld InfoOm;
}
