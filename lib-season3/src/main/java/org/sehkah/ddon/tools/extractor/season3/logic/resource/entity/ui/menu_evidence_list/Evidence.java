package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.ui.menu_evidence_list;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.api.logic.resource.Translation;
import org.sehkah.ddon.tools.extractor.api.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.ui.meta.EvidenceType;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class Evidence {
    private int Step;
    private int Type;
    @MetaInformation
    private EvidenceType EvidenceType;
    private long EvidenceId;
    @MetaInformation
    private Translation EvidenceName;
    @MetaInformation
    private Translation EvidenceInfo;
    private long QuestId;
    @MetaInformation
    private Translation QuestName;
    private long Flag;
}
