package org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season2.stage;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
@JsonPropertyOrder(alphabetic = true)
public class SetInfoOmText extends SetInfo {
    private final long TextNo;
    private final long TextQuestNo;
    private final long TextType;
    private final SetInfoOm InfoOm;
}
