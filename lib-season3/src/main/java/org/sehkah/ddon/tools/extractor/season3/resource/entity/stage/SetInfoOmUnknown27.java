package org.sehkah.ddon.tools.extractor.season3.resource.entity.stage;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.sehkah.ddon.tools.extractor.lib.common.datatype.Vector3f;

@RequiredArgsConstructor
@Getter
@JsonPropertyOrder(alphabetic = true)
public class SetInfoOmUnknown27 extends SetInfo {
    private final int unknown1;
    private final int unknown2;
    private final int unknown3;
    private final long unknown4;
    private final long unknown5;
    private final int unknown6;
    private final Vector3f unknown7;
    private final long unknown8;
    private final int unknown9;
    private final SetInfoOmOld InfoOm;
}
