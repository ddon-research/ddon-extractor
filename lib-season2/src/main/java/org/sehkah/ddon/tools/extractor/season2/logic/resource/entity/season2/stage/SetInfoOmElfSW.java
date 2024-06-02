package org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.season2.stage;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
@JsonPropertyOrder(alphabetic = true)
public class SetInfoOmElfSW extends SetInfo {
    private final long PLCount;
    private final SetInfoOm InfoOm;
}
