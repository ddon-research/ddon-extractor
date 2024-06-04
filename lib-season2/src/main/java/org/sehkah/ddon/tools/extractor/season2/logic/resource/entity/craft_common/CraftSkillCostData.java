package org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.craft_common;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class CraftSkillCostData {
    private long Total;
    private float CostRate1;
    private float CostRate2;
    private float CostRate3;
    private float CostRate4;
}
