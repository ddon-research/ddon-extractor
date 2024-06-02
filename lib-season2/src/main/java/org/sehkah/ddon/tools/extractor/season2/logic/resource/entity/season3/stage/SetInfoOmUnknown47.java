package org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.season3.stage;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
@JsonPropertyOrder(alphabetic = true)
public class SetInfoOmUnknown47 extends SetInfo {
    private final long unknown1;
    private final boolean unknown2;
    private final int unknown3;
    private final boolean unknown4;
    private final SetInfoOmOld InfoOm;
}
