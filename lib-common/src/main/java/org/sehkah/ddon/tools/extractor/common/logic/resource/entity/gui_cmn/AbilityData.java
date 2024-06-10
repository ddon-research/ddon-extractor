package org.sehkah.ddon.tools.extractor.common.logic.resource.entity.gui_cmn;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.api.logic.resource.Translation;
import org.sehkah.ddon.tools.extractor.api.serialization.MetaInformation;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class AbilityData {
    private int Id;
    private int MsgNameIndex;
    @MetaInformation
    private Translation AbilityName;
    private int MsgExpIndex;
    @MetaInformation
    private Translation AbilityInfo;
    private int IconId;
    private int Cost;
    private int SortNo;
    private boolean IsPawnDisable;
}
