package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.stage;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.api.datatype.Vector4f;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class SetInfoOmLavaGeyser extends SetInfo {
    private long Unknown1;
    private long Unknown2;
    private int Unknown3;
    private boolean Unknown4;
    private Vector4f Unknown5; // Eruption vector/ray
    private SetInfoOmOld InfoOm;
}
