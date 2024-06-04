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
public class CraftWepQualityParamData {
    private long ItemRank;
    private long WepCategory;
    private long Attack;
    private long MagicAttack;
    private long PowerRev;
    private long StanSav;
    private long Chance;
    private long ShieldStagger;
    private long ShieldStamina;
    private long TShieldStorage;
    private int Lv;
}
