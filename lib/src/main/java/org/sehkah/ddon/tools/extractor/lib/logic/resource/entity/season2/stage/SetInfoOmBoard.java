package org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season2.stage;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
@JsonPropertyOrder(alphabetic = true)
public class SetInfoOmBoard extends SetInfo {
    private final long BoardID;
    private final SetInfoOm InfoOm;
}