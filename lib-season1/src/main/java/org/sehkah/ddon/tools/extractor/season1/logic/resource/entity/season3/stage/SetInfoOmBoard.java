package org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.season3.stage;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
@JsonPropertyOrder(alphabetic = true)
public class SetInfoOmBoard extends SetInfo {
    private final long BoardID;
    private final SetInfoOmOld InfoOm;
}
