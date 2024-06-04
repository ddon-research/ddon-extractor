package org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.stage;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;

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
    private boolean IsQuest;
    private long QuestId;
    private List<SetInfoOmCtrlLinkParam> LinkParam; // 4
    private int AddGroupNo;
    private int AddSubGroupNo;
    private SetInfoOm InfoOm;
}
