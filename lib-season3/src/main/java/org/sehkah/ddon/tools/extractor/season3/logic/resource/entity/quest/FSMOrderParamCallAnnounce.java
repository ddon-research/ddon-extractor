package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.quest;


import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.api.logic.resource.Translation;
import org.sehkah.ddon.tools.extractor.api.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.quest.meta.ParamCallAnnounceType;


@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class FSMOrderParamCallAnnounce extends AICopiableParameter {
    private long Type;
    @MetaInformation
    private ParamCallAnnounceType TypeName;
    private long QuestId;
    @MetaInformation
    private Translation QuestName;
    // TODO: Lookup
    private long MsgNo;
}
