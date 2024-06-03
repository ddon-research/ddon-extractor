package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.base;


import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class IncreaseParam {
    private long Lv;
    private long Atk;
    private long Def;
    private long MAtk;
    private long MDef;
}
