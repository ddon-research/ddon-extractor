package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.craft_common;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class CraftCapPassData {
    private long RecipeId;
    private int StartLv;
    private int LvCap;
    private int Ver;
    private int Round;
    private int Type;
}
