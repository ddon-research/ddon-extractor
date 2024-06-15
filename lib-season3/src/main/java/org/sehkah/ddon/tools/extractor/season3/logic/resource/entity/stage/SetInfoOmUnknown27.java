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
public class SetInfoOmUnknown27 extends SetInfo {
    private int unknown1;
    private int unknown2;
    private int unknown3;
    private long unknown4;
    private long unknown5;
    private int unknown6;
    private Vector3f unknown7;
    private long unknown8;
    private int unknown9;
    private SetInfoOmOld InfoOm;
}
