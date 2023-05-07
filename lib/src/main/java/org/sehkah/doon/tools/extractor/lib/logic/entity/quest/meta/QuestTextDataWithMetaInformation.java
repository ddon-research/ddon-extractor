package org.sehkah.doon.tools.extractor.lib.logic.entity.quest.meta;

import org.sehkah.doon.tools.extractor.lib.logic.entity.quest.QuestTextData;

public record QuestTextDataWithMetaInformation(
        long Type,
        QuestTextType TypeName,
        long MsgGmdIdx
) {
    public QuestTextDataWithMetaInformation(QuestTextData questTextData) {
        this(
                questTextData.Type(), QuestTextType.of(questTextData.Type()),
                questTextData.MsgGmdIdx()
        );
    }
}
