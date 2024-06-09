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
public class SetInfoOmUnknown42 extends SetInfo {
    private boolean Unknown1;
    private int Unknown2;
    private int Unknown3;
    private int Unknown4;
    private int Unknown5;
    private int Unknown6;
    private boolean Unknown7;
    private SetInfoOmOld InfoOm;
}
