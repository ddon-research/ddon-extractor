package org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.game_common;

import org.sehkah.ddon.tools.extractor.lib.logic.MessageFileLookupType;
import org.sehkah.ddon.tools.extractor.lib.logic.MessageLookupUtil;
import org.sehkah.ddon.tools.extractor.lib.logic.serialization.MetaInformation;

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
                msgIndex, MessageLookupUtil.getMessage(MessageFileLookupType.ENEMY_NAME, msgIndex),
                emList);
    }
}
