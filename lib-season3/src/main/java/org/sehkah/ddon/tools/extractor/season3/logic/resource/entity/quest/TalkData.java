package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.quest;

import org.sehkah.ddon.tools.extractor.lib.common.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.quest.meta.AIPawnPersonalityType;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.quest.meta.PawnQuestTalkMessageType;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.quest.meta.PawnQuestTalkResourceType;

public record TalkData(
        long GroupSerial,
        int MsgType,
        @MetaInformation
        PawnQuestTalkMessageType MsgTypeName,
        int ResType,
        @MetaInformation
        PawnQuestTalkResourceType ResTypeName,
        int Personality,
        @MetaInformation
        AIPawnPersonalityType PersonalityType
) {
    public TalkData(long groupSerial, int msgType, int resType, int personality) {
        this(
                groupSerial,
                msgType, PawnQuestTalkMessageType.of(msgType),
                resType, PawnQuestTalkResourceType.of(resType),
                personality, AIPawnPersonalityType.of(personality)
        );
    }
}
