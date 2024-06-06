package org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.game_common;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceFileLookupType;
import org.sehkah.ddon.tools.extractor.api.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.ResourceMetadataLookupUtilSeason2;

import java.util.List;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class FieldAreaInfo {
    private long FieldAreaId;
    private long GmdIdx;
    @MetaInformation
    private String FieldAreaName;
    private int LandId;
    private int AreaId;
    private List<StageNo> StageNoList;
    private List<StageNo> BelongStageNoList;

    public FieldAreaInfo(long fieldAreaId, long gmdIdx, int landId, int areaId, List<StageNo> stageNoList, List<StageNo> belongStageNoList) {
        this(fieldAreaId,
                gmdIdx, ResourceMetadataLookupUtilSeason2.getMessage(ResourceFileLookupType.FIELD_AREA_NAME, gmdIdx),
                landId,
                areaId,
                stageNoList,
                belongStageNoList);
    }
}
