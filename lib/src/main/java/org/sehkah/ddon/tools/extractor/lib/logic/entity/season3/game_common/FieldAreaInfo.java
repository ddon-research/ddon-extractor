package org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.game_common;

import org.sehkah.ddon.tools.extractor.lib.logic.MessageFileLookupType;
import org.sehkah.ddon.tools.extractor.lib.logic.MessageLookupUtil;
import org.sehkah.ddon.tools.extractor.lib.logic.serialization.MetaInformation;

import java.util.List;

public record FieldAreaInfo(
        long FieldAreaId,
        long GmdIdx,
        @MetaInformation
        String FieldAreaName,
        int LandId,
        int AreaId,
        List<StageNo> StageNoList,
        List<StageNo> BelongStageNoList
) {
    public FieldAreaInfo(long fieldAreaId, long gmdIdx, int landId, int areaId, List<StageNo> stageNoList, List<StageNo> belongStageNoList) {
        this(fieldAreaId,
                gmdIdx, MessageLookupUtil.getMessage(MessageFileLookupType.FIELD_AREA_NAME, gmdIdx),
                landId,
                areaId,
                stageNoList,
                belongStageNoList);
    }
}
