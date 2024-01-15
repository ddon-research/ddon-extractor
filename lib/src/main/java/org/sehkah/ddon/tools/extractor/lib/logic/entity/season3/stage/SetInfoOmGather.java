package org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.stage;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class SetInfoOmGather extends SetInfo {
    private final long ItemListID;
    private final long GatheringType;
    private final boolean IsGatherEnemy;
    private final SetInfoOm InfoOm;
}
