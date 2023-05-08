package org.sehkah.doon.tools.extractor.lib.logic.entity.quest;

import org.sehkah.doon.tools.extractor.lib.logic.entity.quest.meta.QuestTextType;
import org.sehkah.doon.tools.extractor.lib.logic.serialization.MetaInformation;

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
