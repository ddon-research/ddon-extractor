package org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.stage;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@Getter
public class SetInfoOmCtrl extends SetInfo {
    private final long KeyItemNo;
    private final boolean IsQuest;
    private final long QuestId;
    private final List<SetInfoOmCtrlLinkParam> LinkParam; // 4
    private final int AddGroupNo;
    private final int AddSubGroupNo;
    private final SetInfoOm InfoOm;
}
