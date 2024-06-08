package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.game_common;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
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
    private String FieldAreaName;
    private int LandId;
    private int AreaId;
    private List<StageNo> StageNoList;
    private List<StageNo> BelongStageNoList;
}
