package org.sehkah.doon.tools.extractor.lib.logic.entity.gui_cmn;

public record AbilityData(
        int Id,
        int MsgNameIndex,
        int MsgExpIndex,
        int IconId,
        int Cost,
        int SortNo,
        boolean IsPawnDisable
) {
}