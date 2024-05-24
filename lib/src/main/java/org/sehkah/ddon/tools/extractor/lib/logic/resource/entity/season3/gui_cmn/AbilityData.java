package org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.gui_cmn;

import org.sehkah.ddon.tools.extractor.lib.common.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.DynamicResourceLookupUtil;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ResourceFileLookupType;

public record AbilityData(
        int Id,
        int MsgNameIndex,
        @MetaInformation
        String AbilityName,
        int MsgExpIndex,
        @MetaInformation
        String AbilityInfo,
        int IconId,
        int Cost,
        int SortNo,
        boolean IsPawnDisable
) {
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
