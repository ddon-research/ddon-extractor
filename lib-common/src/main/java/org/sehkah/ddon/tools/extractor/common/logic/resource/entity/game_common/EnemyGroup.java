package org.sehkah.ddon.tools.extractor.common.logic.resource.entity.game_common;

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
public class EnemyGroup {
    // List of IDs which correspond to hexadecimal file name suffix, e.g. em010100 == 65792 with MsgIndex 0 == ゴブリン (Goblin);
    private long EnemyGroupId;
    private long MsgIndex;
    @MetaInformation
    private String EnemyGroupName;
    private List<Long> EmList;
}
