package org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.stage;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.sehkah.ddon.tools.extractor.lib.common.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.stage.meta.SetInfoOmGatherType;

@RequiredArgsConstructor
@Getter
@JsonPropertyOrder(alphabetic = true)
public class SetInfoOmGather extends SetInfo {
    private final long ItemListID;
    private final long GatheringType;
    @MetaInformation
    private final SetInfoOmGatherType GatheringTypeName;
    private final boolean IsGatherEnemy;
    private final SetInfoOm InfoOm;

    public SetInfoOmGather(long itemListID, long gatheringType, boolean isGatherEnemy, SetInfoOm infoOm) {
        this(itemListID,
                gatheringType, SetInfoOmGatherType.of(gatheringType),
                isGatherEnemy,
                infoOm);
    }
}
