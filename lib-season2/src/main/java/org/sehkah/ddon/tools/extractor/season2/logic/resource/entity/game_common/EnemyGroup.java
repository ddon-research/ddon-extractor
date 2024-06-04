package org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.game_common;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.lib.common.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ResourceFileLookupType;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.DynamicResourceLookupUtil;

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
    private List<Long> EmList;

    // List of IDs which correspond to hexadecimal file name suffix, e.g. em010100 == 65792 with MsgIndex 0 == ゴブリン (Goblin);
    public EnemyGroup(long enemyGroupId, long msgIndex, List<Long> emList) {
        this(enemyGroupId,
                msgIndex, DynamicResourceLookupUtil.getMessage(ResourceFileLookupType.ENEMY_NAME, msgIndex),
                emList);
    }
}
