package org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.stage;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.sehkah.ddon.tools.extractor.lib.common.datatype.Vector4f;

@RequiredArgsConstructor
@Getter
@JsonPropertyOrder(alphabetic = true)
public class SetInfoOmUnknown31 extends SetInfo {
    private final Vector4f Unknown;
    private final SetInfoOmOld InfoOm;
}
