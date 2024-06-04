package org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.game_common;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class HumanEnemyCustomSkill {
    private long Id;
    private long CustomSkill0;
    private long CustomSkill1;
    private long CustomSkill2;
    private long CustomSkill3;
    private long CustomLevel0;
    private long CustomLevel1;
    private long CustomLevel2;
    private long CustomLevel3;
}
