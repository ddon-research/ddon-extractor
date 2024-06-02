package org.sehkah.ddon.tools.extractor.season3.resource.entity.stage;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
@JsonPropertyOrder(alphabetic = true)
public class SetInfoOmHakuryuu extends SetInfo {
    private final long StoneLevel;
    private final SetInfoOmOld InfoOm;
}
