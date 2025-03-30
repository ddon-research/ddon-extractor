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
public class SetInfoOmRimWarp extends SetInfo {
    private boolean NoWarp;
    // TODO: Lookup
    private int Kind;
    private int Group;
    private int ID;
    private List<Long> StageNo;
    @MetaInformation
    private List<Translation> StageNames;
    private List<Long> StartPosNo;
    private List<Long> QuestId;
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
    private SetInfoOm InfoOm;
}
