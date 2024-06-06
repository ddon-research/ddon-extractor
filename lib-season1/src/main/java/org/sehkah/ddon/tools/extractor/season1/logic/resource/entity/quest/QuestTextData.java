package org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.quest;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.api.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.quest.meta.QuestTextType;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class QuestTextData {
    private long Type;
    @MetaInformation
    private QuestTextType TypeName;
    // TODO: For every QTD there is a corresponding GMD, e.g. for quest/q00000010/ui: 00_param/quest_text/q00000010_00.qtd.json => 00_message/quest_info/q00000010_00.gmd.json
    private long MsgGmdIdx;

    public QuestTextData(long type, long msgGmdIdx) {
        this(
                type, QuestTextType.of(type),
                msgGmdIdx);
    }
}
