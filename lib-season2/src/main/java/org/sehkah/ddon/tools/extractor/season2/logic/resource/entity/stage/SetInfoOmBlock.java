package org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.stage;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
@JsonPropertyOrder(alphabetic = true)
public class SetInfoOmBlock extends SetInfo {
    private final long QuestID;
    private final SetInfoOm InfoOm;
}
