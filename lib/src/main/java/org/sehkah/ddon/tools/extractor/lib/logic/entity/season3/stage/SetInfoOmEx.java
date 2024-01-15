package org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.stage;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class SetInfoOmEx extends SetInfo {
    private final long QuestID;
    private final SetInfoOm InfoOm;
}
