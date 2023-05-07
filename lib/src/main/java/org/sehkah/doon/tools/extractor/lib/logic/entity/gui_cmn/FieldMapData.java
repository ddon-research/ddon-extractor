package org.sehkah.doon.tools.extractor.lib.logic.entity.gui_cmn;

import org.sehkah.doon.tools.extractor.lib.common.datatype.Float2f;
import org.sehkah.doon.tools.extractor.lib.common.datatype.Vector3f;

public record FieldMapData(
        long Type,
        int MessId,
        long ID,
        int StageNo,
        Float2f Point,
        Vector3f WorldPos,
        boolean DispWideMap,
        long QuestId
) {
}
