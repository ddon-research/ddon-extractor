package org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.stage;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.api.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.stage.meta.SetInfoOmGatherType;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class SetInfoOmGather extends SetInfo {
    private long ItemListID;
    private long GatheringType;
    @MetaInformation
    private SetInfoOmGatherType GatheringTypeName;
    private boolean IsGatherEnemy;
    private SetInfoOm InfoOm;

    public SetInfoOmGather(long itemListID, long gatheringType, boolean isGatherEnemy, SetInfoOm infoOm) {
        this(itemListID,
                gatheringType, SetInfoOmGatherType.of(gatheringType),
                isGatherEnemy,
                infoOm);
    }
}
