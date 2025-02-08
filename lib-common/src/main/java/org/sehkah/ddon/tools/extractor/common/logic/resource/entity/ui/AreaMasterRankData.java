package org.sehkah.ddon.tools.extractor.common.logic.resource.entity.ui;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.api.logic.resource.Translation;
import org.sehkah.ddon.tools.extractor.api.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.ui.meta.AreaMasterRankBonusType;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class AreaMasterRankData {
    private long MsgGroupSerial;
    @MetaInformation
    private Translation Message;
    private long Point;
    private int BonusType;
    @MetaInformation
    private AreaMasterRankBonusType BonusTypeName;

    public AreaMasterRankData(long msgGroupSerial, Translation message, long point, int bonusType) {
        MsgGroupSerial = msgGroupSerial;
        Message = message;
        Point = point;
        BonusType = bonusType;
        BonusTypeName = AreaMasterRankBonusType.of(bonusType);
    }
}
