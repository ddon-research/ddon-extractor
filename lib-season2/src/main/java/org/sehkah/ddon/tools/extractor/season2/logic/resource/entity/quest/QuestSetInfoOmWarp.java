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
public class QuestSetInfoOmWarp extends SetInfo {
    private QuestSetInfoOm InfoOm;
    private List<Long> StageNo;
    @MetaInformation
    private List<Translation> StageNames;
    private List<Long> StartPosNo;
    private List<Long> QuestId; // QuestNo
    @MetaInformation
    private List<Translation> QuestNames;
    private List<Long> FlagNo;
    private List<Long> SpotId;
    @MetaInformation
    private List<Translation> SpotNames;
    private long TextType;
    private long TextQuestNo;
    // TODO: Lookup
    private long TextNo;
}
