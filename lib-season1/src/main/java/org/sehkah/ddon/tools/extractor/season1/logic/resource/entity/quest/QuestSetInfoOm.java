package org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.quest;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.stage.SetInfo;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class QuestSetInfoOm extends SetInfo {
    private QuestSetInfoCoord InfoCoord;
    private boolean DisableEffect;
    private boolean DisableOnlyEffect;
    private boolean OpenFlag;
    private boolean EnableSyncLight;
    private boolean EnableZone;
    private long InitMtnNo;
    private long AreaMasterNo;
    private int AreaReleaseNo;
    private boolean AreaReleaseON;
    private boolean AreaReleaseOFF;
    private long WarpPointId;
    private long KeyNo;
    private boolean IsBreakLink;
    private boolean IsBreakQuest;
    private int BreakKind;
    private int BreakGroup;
    private int BreakID;
    private long QuestFlag;
    private boolean IsNoSbc;
    private boolean IsMyQuest;
}
