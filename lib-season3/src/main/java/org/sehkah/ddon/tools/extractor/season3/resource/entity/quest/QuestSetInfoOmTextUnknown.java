package org.sehkah.ddon.tools.extractor.season3.resource.entity.quest;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.sehkah.ddon.tools.extractor.season3.resource.entity.stage.SetInfo;

@RequiredArgsConstructor
@Getter
@JsonPropertyOrder(alphabetic = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class QuestSetInfoOmTextUnknown extends SetInfo { // TODO: JamCRC 100955604 => unknown name
    private final QuestSetInfoOm InfoOm;
    private final long TextNo;
    private final long TextQuestNo;
    private final long TextType;
    private final long PLActNo;
}
