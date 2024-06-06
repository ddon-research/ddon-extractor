package org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.quest;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.api.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.quest.meta.AIPawnPersonalityType;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.quest.meta.PawnQuestTalkMessageType;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.quest.meta.PawnQuestTalkResourceType;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class TalkData {
    private long GroupSerial;
    private int MsgType;
    @MetaInformation
    private PawnQuestTalkMessageType MsgTypeName;
    private int ResType;
    @MetaInformation
    private PawnQuestTalkResourceType ResTypeName;
    private int Personality;
    @MetaInformation
    private AIPawnPersonalityType PersonalityType;

    public TalkData(long groupSerial, int msgType, int resType, int personality) {
        this(
                groupSerial,
                msgType, PawnQuestTalkMessageType.of(msgType),
                resType, PawnQuestTalkResourceType.of(resType),
                personality, AIPawnPersonalityType.of(personality)
        );
    }
}
