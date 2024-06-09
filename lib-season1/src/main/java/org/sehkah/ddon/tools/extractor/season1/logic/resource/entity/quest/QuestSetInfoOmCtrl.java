package org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.quest;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.stage.SetInfo;

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
    private long KeyItemNo;
    private boolean IsQuest;
    private long QuestId;
    private List<QuestSetInfoOmCtrlLinkParam> LinkParam; // 4
    private int AddGroupNo;
    private int AddSubGroupNo;
}
