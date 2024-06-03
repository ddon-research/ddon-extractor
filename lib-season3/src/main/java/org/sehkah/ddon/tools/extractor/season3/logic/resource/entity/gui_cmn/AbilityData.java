package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.gui_cmn;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.lib.common.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ResourceFileLookupType;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.DynamicResourceLookupUtil;

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
    private String AbilityName;
    private int MsgExpIndex;
    @MetaInformation
    private String AbilityInfo;
    private int IconId;
    private int Cost;
    private int SortNo;
    private boolean IsPawnDisable;

    public AbilityData(int id, int msgNameIndex, int msgExpIndex, int iconId, int cost, int sortNo, boolean isPawnDisable) {
        this(id,
                msgNameIndex, DynamicResourceLookupUtil.getMessage(ResourceFileLookupType.ABILITY_NAME, msgNameIndex),
                msgExpIndex, DynamicResourceLookupUtil.getMessage(ResourceFileLookupType.ABILITY_INFO, msgExpIndex),
                iconId,
                cost,
                sortNo,
                isPawnDisable);
    }
}
