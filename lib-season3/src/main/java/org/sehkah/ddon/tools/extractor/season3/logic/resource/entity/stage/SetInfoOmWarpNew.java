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
public class SetInfoOmWarpNew extends SetInfo {
    private long UnknownStageNo;
    private List<Long> StageNo;
    private List<Long> StartPosNo;
    private List<Long> QuestNo;
    private List<Long> FlagNo;
    private List<Long> SpotId;
    private long TextType;
    private long TextQuestNo;
    private long TextNo;
    private SetInfoOm InfoOm;
}
