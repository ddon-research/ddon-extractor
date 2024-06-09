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
public class SetInfoOmUnknown53 extends SetInfo {
    private long Unknown1;
    private boolean Unknown2; // TODO Check if boolean might come first
    private int Unknown3;
    private SetInfoOmOld InfoOm;
}
