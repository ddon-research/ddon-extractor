package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.game_common;

import org.sehkah.ddon.tools.extractor.lib.common.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ResourceFileLookupType;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.DynamicResourceLookupUtil;

import java.util.List;

public record EnemyGroup(
        long EnemyGroupId,
        long MsgIndex,
        @MetaInformation
        String EnemyGroupName,
        List<Long> EmList
        // List of IDs which correspond to hexadecimal file name suffix, e.g. em010100 == 65792 with MsgIndex 0 == ゴブリン (Goblin)
) {
    public EnemyGroup(long enemyGroupId, long msgIndex, List<Long> emList) {
        this(enemyGroupId,
                msgIndex, DynamicResourceLookupUtil.getMessage(ResourceFileLookupType.ENEMY_NAME, msgIndex),
                emList);
    }
}
