package org.sehkah.ddon.tools.extractor.common.logic.resource.entity.ui.uGUISkill;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class AbilityLevelData {
    private int NeedLv;
    private long NeedJp;
}
