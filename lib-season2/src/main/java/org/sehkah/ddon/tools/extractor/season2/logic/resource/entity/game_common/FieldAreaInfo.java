package org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.game_common;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.api.logic.resource.Translation;
import org.sehkah.ddon.tools.extractor.api.serialization.MetaInformation;

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
    private Translation FieldAreaName;
    private int LandId;
    @MetaInformation
    private Translation LandName;
    private int AreaId;
    @MetaInformation
    private Translation AreaName;
    private List<StageNo> StageNoList;
    private List<StageNo> BelongStageNoList;
}
