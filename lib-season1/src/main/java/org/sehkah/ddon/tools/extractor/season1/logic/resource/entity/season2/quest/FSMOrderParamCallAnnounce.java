package org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.season2.quest;


import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.sehkah.ddon.tools.extractor.lib.common.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.season3.quest.meta.ParamCallAnnounceType;


@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@RequiredArgsConstructor
@Getter
@JsonPropertyOrder(alphabetic = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class FSMOrderParamCallAnnounce extends AICopiableParameter {
    private final long Type;
    @MetaInformation
    private final ParamCallAnnounceType TypeName;
    private final long QuestId;
    private final long MsgNo;

    public FSMOrderParamCallAnnounce(long type, long questId, long msgNo) {
        Type = type;
        TypeName = ParamCallAnnounceType.of((int) Type);
        QuestId = questId;
        MsgNo = msgNo;
    }
}
