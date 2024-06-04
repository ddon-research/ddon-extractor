package org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.game_common;


import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;

import java.util.List;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class CalcDamageLvAdj {
    private short LvDiff;
    private List<Float> LvAdj;
}
