package org.sehkah.ddon.tools.extractor.common.logic.resource.entity.ui.uGUISkill;

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
public class AbilityAddData {
    private int Id;
    private int SortCategory;
    private List<AbilityLevelData> LvArray;
}
