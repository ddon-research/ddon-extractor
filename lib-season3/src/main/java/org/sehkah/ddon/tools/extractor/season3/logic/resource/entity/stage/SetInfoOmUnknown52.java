package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.stage;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.lib.common.datatype.Vector3f;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class SetInfoOmUnknown52 extends SetInfo {
    private Vector3f Unknown1;
    private Vector3f Unknown2;
    private float Unknown3;
    private float Unknown4;
    private long Unknown5;
    private long Unknown6;
    private SetInfoOmOld InfoOm;
}
