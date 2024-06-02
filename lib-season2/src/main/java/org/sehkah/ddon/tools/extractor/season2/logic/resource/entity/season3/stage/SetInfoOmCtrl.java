package org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.season3.stage;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@Getter
@JsonPropertyOrder(alphabetic = true)
public class SetInfoOmCtrl extends SetInfo {
    private final long KeyItemNo;
    private final boolean IsQuest;
    private final long QuestId;
    private final List<SetInfoOmCtrlLinkParam> LinkParam; // 4
    private final int AddGroupNo;
    private final int AddSubGroupNo;
    private final long EmHpRate;
    private final SetInfoOmOld InfoOm;
}
