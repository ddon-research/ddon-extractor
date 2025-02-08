package org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.quest;


import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
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
    // TODO lookup MsgNo -> Serial via questid MSS file
    private long MsgNo;

    public FSMOrderParamCallAnnounce(long type, long questId, long msgNo) {
        Type = type;
        TypeName = ParamCallAnnounceType.of((int) Type);
        QuestId = questId;
        MsgNo = msgNo;
    }
}
