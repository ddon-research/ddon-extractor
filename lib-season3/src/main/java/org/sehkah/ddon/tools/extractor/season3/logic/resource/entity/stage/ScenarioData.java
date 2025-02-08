package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.stage;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class ScenarioData {
    private ScenarioParam Param;
    private ScenarioAreaHitShape Shape;
    private ScenarioArg Arg;
    private int Index;
}
