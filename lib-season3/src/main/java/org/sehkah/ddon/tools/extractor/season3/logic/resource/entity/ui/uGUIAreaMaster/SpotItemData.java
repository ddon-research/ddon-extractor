package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.ui.uGUIAreaMaster;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class SpotItemData {
    // TODO: Lookup
    private long ItemId;
    private boolean IsFeature;
    private boolean IsCannotPawnTake;
    private int UnknownByte1;
    private int UnknownByte2;
}
