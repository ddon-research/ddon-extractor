package org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.season3.quest;

import org.sehkah.ddon.tools.extractor.lib.common.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.season3.quest.meta.QuestTextType;

public record QuestTextData(
        long Type,
        @MetaInformation
        QuestTextType TypeName,
        // TODO: For every QTD there is a corresponding GMD, e.g. for quest/q00000010/ui: 00_param/quest_text/q00000010_00.qtd.json => 00_message/quest_info/q00000010_00.gmd.json
        long MsgGmdIdx
) {
    public QuestTextData(long type, long msgGmdIdx) {
        this(
                type, QuestTextType.of(type),
                msgGmdIdx);
    }
}
