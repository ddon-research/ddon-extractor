package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.ui.uGUIAreaMaster;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.api.logic.resource.Translation;
import org.sehkah.ddon.tools.extractor.api.serialization.MetaInformation;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class SpotItemData {
    private long ItemId;
    @MetaInformation
    private Translation ItemName;
    // Relates to the SpotEnemyData Unknown, both always have values >0 at the same time
    private int Unknown;
    private boolean IsCannotPawnTake;
    private boolean IsFeature;
}
