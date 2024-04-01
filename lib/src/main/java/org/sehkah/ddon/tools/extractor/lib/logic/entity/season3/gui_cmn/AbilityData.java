package org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.gui_cmn;

import org.sehkah.ddon.tools.extractor.lib.logic.MessageFileLookupType;
import org.sehkah.ddon.tools.extractor.lib.logic.MessageLookupUtil;
import org.sehkah.ddon.tools.extractor.lib.logic.serialization.MetaInformation;

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
                msgNameIndex, MessageLookupUtil.getMessage(MessageFileLookupType.ABILITY_NAME, msgNameIndex),
                msgExpIndex, MessageLookupUtil.getMessage(MessageFileLookupType.ABILITY_INFO, msgExpIndex),
                iconId,
                cost,
                sortNo,
                isPawnDisable);
    }
}
