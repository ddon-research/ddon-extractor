package org.sehkah.ddon.tools.extractor.lib.logic.entity.season2.stage;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
@JsonPropertyOrder(alphabetic = true)
public class SetInfoOmBreakTarget extends SetInfo {
    private final long BreakHitNum;
    private final SetInfoOm InfoOm;
}