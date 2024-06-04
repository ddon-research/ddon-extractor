package org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.ui.uGUIAreaMaster;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class AreaMasterRankData {
    private long MsgGroupSerial;
    private long Point;
    private int BonusType;
}
