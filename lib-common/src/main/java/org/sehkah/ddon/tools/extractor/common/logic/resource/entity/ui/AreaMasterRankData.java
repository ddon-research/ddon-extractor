package org.sehkah.ddon.tools.extractor.common.logic.resource.entity.ui;

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
    // TODO: Lookup
    private long MsgGroupSerial;
    private long Point;
    //TODO: find enum
    private int BonusType;
}
