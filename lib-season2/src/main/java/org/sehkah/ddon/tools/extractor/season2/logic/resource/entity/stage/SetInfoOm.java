package org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.stage;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class SetInfoOm extends SetInfo {
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
    private SetInfoCoord InfoCoord;
}
