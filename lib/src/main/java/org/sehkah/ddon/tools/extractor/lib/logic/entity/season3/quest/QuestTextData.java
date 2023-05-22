package org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.quest;

import org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.quest.meta.QuestTextType;
import org.sehkah.ddon.tools.extractor.lib.logic.serialization.MetaInformation;

public record QuestTextData(
        long Type,
        @MetaInformation
        QuestTextType TypeName,
        long MsgGmdIdx
) {
    public QuestTextData(long type, long msgGmdIdx) {
        this(
                type, QuestTextType.of(type),
                msgGmdIdx);
    }
}
