package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.quest;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.stage.SetInfo;

import java.util.List;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class QuestSetInfoOmWarp extends SetInfo {
    private QuestSetInfoOm InfoOm;
    // TODO: Lookup
    private List<Long> StageNo;
    private List<Long> StartPosNo;
    private List<Long> QuestId;//QuestNo
    private List<Long> FlagNo;
    // TODO: Lookup
    private List<Long> SpotId;
    private long TextType;
    private long TextQuestNo;
    // TODO: Lookup
    private long TextNo;
    private boolean NoWarp;
}
