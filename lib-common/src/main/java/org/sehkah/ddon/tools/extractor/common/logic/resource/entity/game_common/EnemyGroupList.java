package org.sehkah.ddon.tools.extractor.common.logic.resource.entity.game_common;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.sehkah.ddon.tools.extractor.api.entity.Resource;

import java.util.List;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
@Slf4j
public class EnemyGroupList extends Resource {
    private List<EnemyGroup> EnemyGroupList;

    public EnemyGroup getEnemyById(long enemyId) {
        return getEnemyByIdNaive(enemyId);
    }

    private EnemyGroup getEnemyByIdNaive(long enemyId) {
        for (EnemyGroup enemyGroup : EnemyGroupList) {
            for (long l : enemyGroup.getEmList()) {
                if (l == enemyId) {
                    return enemyGroup;
                }
            }
        }
        // TODO: investigate these cases
        log.error("Could not find enemy group for id {}", enemyId);
        return null;
    }
}
