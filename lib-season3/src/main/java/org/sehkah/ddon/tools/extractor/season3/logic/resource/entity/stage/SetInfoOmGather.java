package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.stage;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.lib.common.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.stage.meta.SetInfoOmGatherType;

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
    private SetInfoOmOld InfoOm;

    public SetInfoOmGather(long itemListID, long gatheringType, boolean isGatherEnemy, SetInfoOmOld infoOm) {
        this(itemListID,
                gatheringType, SetInfoOmGatherType.of(gatheringType),
                isGatherEnemy,
                infoOm);
    }
}
