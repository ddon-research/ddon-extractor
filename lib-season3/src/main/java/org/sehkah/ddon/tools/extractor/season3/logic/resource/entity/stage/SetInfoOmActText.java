package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.stage;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.api.logic.resource.Translation;
import org.sehkah.ddon.tools.extractor.api.serialization.MetaInformation;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class SetInfoOmActText extends SetInfo {
    private long PLActNo;
    // TODO: Lookup
    private long TextNo;
    private long TextQuestNo;
    @MetaInformation
    private Translation QuestName;
    // TODO: Lookup
    private long TextType;
    private SetInfoOmOld InfoOm;
}
