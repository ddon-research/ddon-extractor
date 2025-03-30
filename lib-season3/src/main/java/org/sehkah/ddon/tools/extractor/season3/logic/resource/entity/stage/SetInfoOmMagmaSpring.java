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
public class SetInfoOmMagmaSpring extends SetInfo {
    private long Relation;
    private int Grp;
    private int ID;
    private boolean Always;
    private float Length;
    private float JumpLength;
    private float Span;
    private float FireTime;
    private SetInfoOmOld InfoOm;
}
