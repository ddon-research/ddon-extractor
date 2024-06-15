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
public class SetInfoOmUnknown49 extends SetInfo {
    private long unknown1;
    private long unknown2;
    private long unknown3;
    private long unknown4;
    private long unknown5;
    private boolean unknown6;
    private Vector3f unknown7;
    private float unknown8;
    private boolean unknown9;
    private int unknown10;
    private int unknown11;
    private int unknown12;
    private long unknown13;
    private boolean unknown14;
    private SetInfoOmOld InfoOm;
}
