package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.game_common;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceFileLookupType;
import org.sehkah.ddon.tools.extractor.api.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.ResourceMetadataLookupUtilSeason3;

import java.util.List;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class EnemyGroup {
    private long EnemyGroupId;
    private long MsgIndex;
    @MetaInformation
    private String EnemyGroupName;
    // List of IDs which correspond to hexadecimal file name suffix, e.g. em010100 == 65792 with MsgIndex 0 == ゴブリン (Goblin)
    private List<Long> EmList;

    public EnemyGroup(long enemyGroupId, long msgIndex, List<Long> emList) {
        this(enemyGroupId,
                msgIndex, ResourceMetadataLookupUtilSeason3.getMessage(ResourceFileLookupType.ENEMY_NAME, msgIndex),
                emList);
    }
}
