package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.stage;

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
    private long KeyItemNo;
    @MetaInformation
    private Translation KeyItemName;
    private boolean IsQuest;
    private long QuestId;
    @MetaInformation
    private Translation QuestName;
    private List<SetInfoOmCtrlLinkParam> LinkParam; // 4
    private int AddGroupNo;
    private int AddSubGroupNo;
    private long EmHpRate;
    private SetInfoOmOld InfoOm;
}
