package org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.game_common;

import org.sehkah.ddon.tools.extractor.lib.common.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.DynamicResourceLookupUtil;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ResourceFileLookupType;

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
                gmdIdx, DynamicResourceLookupUtil.getMessage(ResourceFileLookupType.FIELD_AREA_NAME, gmdIdx),
                landId,
                areaId,
                stageNoList,
                belongStageNoList);
    }
}