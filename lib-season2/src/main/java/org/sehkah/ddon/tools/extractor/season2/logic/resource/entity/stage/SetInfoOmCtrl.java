package org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.stage;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.api.logic.resource.Translation;
import org.sehkah.ddon.tools.extractor.api.serialization.MetaInformation;

import java.util.List;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class SetInfoOmCtrl extends SetInfo {
    private long KeyItemId;
    @MetaInformation
    private Translation KeyItemName;
    private boolean IsQuest;
    private long QuestId;
    @MetaInformation
    private Translation QuestName;
    private List<SetInfoOmCtrlLinkParam> LinkParam; // 4
    @MetaInformation
    private boolean ControlsKeyDoorMechanism;
    private int AddGroupNo;
    private int AddSubGroupNo;
    private SetInfoOm InfoOm;
}
