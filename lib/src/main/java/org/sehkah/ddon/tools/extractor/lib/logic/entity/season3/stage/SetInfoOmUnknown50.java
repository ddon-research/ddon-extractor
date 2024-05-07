package org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.stage;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.sehkah.ddon.tools.extractor.lib.common.datatype.Vector3f;

@RequiredArgsConstructor
@Getter
@JsonPropertyOrder(alphabetic = true)
public class SetInfoOmUnknown50 extends SetInfo {
    private final float Unknown1;
    private final float Unknown2;
    private final Vector3f Unknown3;
    private final Vector3f Unknown4;
    private final Vector3f Unknown5;
    private final long Unknown6;
    private final long Unknown7;
    private final SetInfoOmOld InfoOm;
}
