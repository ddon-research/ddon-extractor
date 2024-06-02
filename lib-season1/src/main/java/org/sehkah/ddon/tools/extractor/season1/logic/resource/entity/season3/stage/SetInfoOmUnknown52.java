package org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.season3.stage;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.sehkah.ddon.tools.extractor.lib.common.datatype.Vector3f;

@RequiredArgsConstructor
@Getter
@JsonPropertyOrder(alphabetic = true)
public class SetInfoOmUnknown52 extends SetInfo {
    private final Vector3f Unknown1;
    private final Vector3f Unknown2;
    private final float Unknown3;
    private final float Unknown4;
    private final long Unknown5;
    private final long Unknown6;
    private final SetInfoOmOld InfoOm;
}
