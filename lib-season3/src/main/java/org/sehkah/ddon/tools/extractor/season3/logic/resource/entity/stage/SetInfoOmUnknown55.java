package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.stage;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.api.logic.resource.Translation;
import org.sehkah.ddon.tools.extractor.api.serialization.MetaInformation;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class SetInfoOmUnknown55 extends SetInfo {
    private long Unknown1;
    private long Unknown2;
    private long Unknown3;
    private long Unknown4;
    private long Unknown5;
    private long Unknown6;
    private long Unknown7;
    private long Unknown8;
    private long Unknown9;
    private boolean Unknown10;
    private float Unknown11;
    private boolean Unknown12;
    private long Unknown13;
    private int Unknown14;
    private boolean IsQuest;
    private long QuestId; // set to 0 when IsQuest is false
    @MetaInformation
    private Translation QuestName;
    private long QuestFlag; // set to 0 when IsQuest is false
    private SetInfoOmOld InfoOm;
}
