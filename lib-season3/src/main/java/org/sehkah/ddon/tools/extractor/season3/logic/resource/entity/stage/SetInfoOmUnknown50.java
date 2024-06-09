package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.stage;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.api.datatype.Vector3f;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class SetInfoOmUnknown50 extends SetInfo {
    private float Unknown1;
    private float Unknown2;
    private Vector3f Unknown3;
    private Vector3f Unknown4;
    private Vector3f Unknown5;
    private long Unknown6;
    private long Unknown7;
    private SetInfoOmOld InfoOm;
}
