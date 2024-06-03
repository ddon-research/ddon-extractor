package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.stage;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.sehkah.ddon.tools.extractor.lib.common.datatype.Vector4f;

@RequiredArgsConstructor
@Getter
@JsonPropertyOrder(alphabetic = true)
public class SetInfoOmUnknown45 extends SetInfo {
    private final long Unknown1;
    private final long Unknown2;
    private final int Unknown3;
    private final boolean Unknown4;
    private final Vector4f Unknown5;
    private final SetInfoOmOld InfoOm;
}
