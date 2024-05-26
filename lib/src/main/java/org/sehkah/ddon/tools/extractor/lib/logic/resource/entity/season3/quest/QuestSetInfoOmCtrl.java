package org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.quest;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.stage.SetInfo;

import java.util.List;

@RequiredArgsConstructor
@Getter
@JsonPropertyOrder(alphabetic = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class QuestSetInfoOmCtrl extends SetInfo {
    private final QuestSetInfoOm InfoOm;
    private final long KeyItemNo;
    private final boolean IsQuest;
    private final long QuestId;
    private final List<QuestSetInfoOmCtrlLinkParam> LinkParam; // 4
    private final int AddGroupNo;
    private final int AddSubGroupNo;
    private final long EmHpRate;
}
