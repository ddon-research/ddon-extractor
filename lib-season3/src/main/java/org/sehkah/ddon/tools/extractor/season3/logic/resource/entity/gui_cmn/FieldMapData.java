package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.gui_cmn;

import org.sehkah.ddon.tools.extractor.lib.common.datatype.Float2f;
import org.sehkah.ddon.tools.extractor.lib.common.datatype.Vector3f;
import org.sehkah.ddon.tools.extractor.lib.common.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.gui_cmn.meta.FieldMapDataType;

public record FieldMapData(
        long Type,
        @MetaInformation
        FieldMapDataType TypeName,
        int MessId,
        long ID,
        int StageNo,
        Float2f Point,
        Vector3f WorldPos,
        boolean DispWideMap,
        long QuestId
) {
    public FieldMapData(long type, int messId, long ID, int stageNo, Float2f point, Vector3f worldPos, boolean dispWideMap, long questId) {
        this(
                type, FieldMapDataType.of(type),
                messId,
                ID,
                stageNo,
                point,
                worldPos,
                dispWideMap,
                questId);
    }
}
