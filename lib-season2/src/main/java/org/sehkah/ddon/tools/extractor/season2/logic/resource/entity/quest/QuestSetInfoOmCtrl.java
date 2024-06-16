package org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.quest;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.api.logic.resource.Translation;
import org.sehkah.ddon.tools.extractor.api.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.stage.SetInfo;

import java.util.List;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class QuestSetInfoOmCtrl extends SetInfo {
    private QuestSetInfoOm InfoOm;
    private long KeyItemId;
    @MetaInformation
    private Translation KeyItemName;
    private boolean IsQuest;
    // TODO: Lookup
    private long QuestId;
    private List<QuestSetInfoOmCtrlLinkParam> LinkParam; // 4
    private int AddGroupNo;
    private int AddSubGroupNo;
}
