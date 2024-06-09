package org.sehkah.ddon.tools.extractor.common.logic.resource.entity.quest;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.api.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.quest.meta.QuestTextType;

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
    private long MsgGmdIdx;
    @MetaInformation
    private String Message;
}
