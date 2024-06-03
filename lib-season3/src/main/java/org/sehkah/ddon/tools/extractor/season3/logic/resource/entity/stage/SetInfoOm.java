package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.stage;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
@JsonPropertyOrder(alphabetic = true)
public class SetInfoOm extends SetInfo {
    private final boolean DisableEffect;
    private final boolean DisableOnlyEffect;
    private final boolean OpenFlag;
    private final boolean EnableSyncLight;
    private final boolean Unknown;
    private final boolean EnableZone;
    private final long InitMtnNo;
    private final long AreaMasterNo;
    private final int AreaReleaseNo;
    private final boolean AreaReleaseON;
    private final boolean AreaReleaseOFF;
    private final long WarpPointId;
    private final long KeyNo;
    private final boolean IsBreakLink;
    private final boolean IsBreakQuest;
    private final int BreakKind;
    private final int BreakGroup;
    private final int BreakID;
    private final long QuestFlag;
    private final boolean IsNoSbc;
    private final boolean IsMyQuest;
    private final SetInfoCoord InfoCoord;
}
