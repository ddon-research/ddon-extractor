package org.sehkah.doon.tools.extractor.lib.logic.entity.quest;

import org.sehkah.doon.tools.extractor.lib.logic.entity.quest.meta.AIPawnPersonalityType;
import org.sehkah.doon.tools.extractor.lib.logic.entity.quest.meta.PawnQuestTalkMessageType;
import org.sehkah.doon.tools.extractor.lib.logic.entity.quest.meta.PawnQuestTalkResourceType;
import org.sehkah.doon.tools.extractor.lib.logic.serialization.MetaInformation;

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
