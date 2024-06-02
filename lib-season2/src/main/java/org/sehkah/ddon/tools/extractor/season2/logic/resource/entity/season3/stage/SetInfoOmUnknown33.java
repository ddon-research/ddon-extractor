package org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.season3.stage;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
@JsonPropertyOrder(alphabetic = true)
public class SetInfoOmUnknown33 extends SetInfo {
    private final long Unknown1;
    private final long Unknown2;
    private final long Unknown3;
    private final long Unknown4;
    private final SetInfoOmOld InfoOm;
}
