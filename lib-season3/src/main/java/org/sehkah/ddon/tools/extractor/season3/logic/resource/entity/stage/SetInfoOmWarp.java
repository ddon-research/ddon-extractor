package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.stage;

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
public class SetInfoOmWarp extends SetInfo {
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
    private SetInfoOm InfoOm;
}
