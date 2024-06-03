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
public class SetInfoOmUnknown32 extends SetInfo {
    private boolean Unknown1;
    private long Unknown2;
    private long Unknown3;
    private long Unknown4;
    private long Unknown5;
    private long Unknown6;
    private long Unknown7;
    private float Unknown8;
    private long Unknown9;
    private SetInfoOmOld InfoOm;
}
