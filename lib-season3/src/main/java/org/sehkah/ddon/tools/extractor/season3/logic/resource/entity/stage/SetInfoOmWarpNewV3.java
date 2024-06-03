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
public class SetInfoOmWarpNewV3 extends SetInfo {
    private boolean Unknown1;
    private int Unknown2;
    private int Unknown3;
    private int Unknown4;
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
