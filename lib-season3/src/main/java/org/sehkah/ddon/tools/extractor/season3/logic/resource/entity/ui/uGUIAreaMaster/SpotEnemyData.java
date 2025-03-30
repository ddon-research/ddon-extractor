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
public class SpotEnemyData {
    private long EnemyGroupId;
    @MetaInformation
    private Translation EnemyName;
    private long EnemyNamedId;
    @MetaInformation
    private Translation NamedEnemyName;
    private int Level;
    // Relates to the SpotItemData Unknown, both always have values >0 at the same time
    private int UnknownShort;
    private int Rank;
}
