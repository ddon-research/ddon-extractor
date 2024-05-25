package org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season2.quest;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season2.stage.SetInfo;

@RequiredArgsConstructor
@Getter
@JsonPropertyOrder(alphabetic = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class QuestSetInfoOm extends SetInfo {
    private final QuestSetInfoCoord InfoCoord;
    private final boolean DisableEffect;
    private final boolean DisableOnlyEffect;
    private final boolean OpenFlag;
    private final boolean EnableSyncLight;
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
}
